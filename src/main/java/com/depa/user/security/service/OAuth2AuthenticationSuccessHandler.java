package com.depa.user.security.service;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.depa.user.dto.UserPrincipal;
import com.depa.user.model.user.User;
import com.depa.user.model.user.impl.UserFactory;
import com.depa.user.repository.UserRepository;
import com.depa.user.security.config.AppProperties;
import com.depa.user.security.exception.BadRequestException;
import com.depa.user.security.repository.HttpCookieOAuth2AuthorizationRequestRepository;
import com.depa.user.service.TokenProvider;

import lombok.SneakyThrows;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private static final String REDIRECT_URI_PARAM_COOKIE_NAME = "redirect_uri";
	private TokenProvider tokenProvider;

	private AppProperties appProperties;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

	@Autowired
	OAuth2AuthenticationSuccessHandler(TokenProvider tokenProvider, AppProperties appProperties,
			HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository) {
		this.tokenProvider = tokenProvider;
		this.appProperties = appProperties;
		this.httpCookieOAuth2AuthorizationRequestRepository = httpCookieOAuth2AuthorizationRequestRepository;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargetUrl(request, response, authentication);

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		clearAuthenticationAttributes(request, response);
		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}

	@SneakyThrows
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		Optional<String> redirectUri = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME).map(Cookie::getValue);

		if (redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
			throw new BadRequestException(
					"Sorry! We've got an Unauthorized Redirect URI and can't proceed with the authentication");
		}

		String targetUrl = redirectUri.orElse(getDefaultTargetUrl());

		if (authentication.isAuthenticated() && isOAuth2Provider(authentication)) {
			UserPrincipal userPrincipal = UserPrincipal.create(authentication.getPrincipal());
			UserDetails userDetails = userDetailsService.loadUserByUsername(userPrincipal.getEmail());
			if (userDetails == null) {
				User user = UserFactory.create(userPrincipal, getRegistrationId(authentication));
				userRepository.save(user);
				String token = tokenProvider.createToken(user.getId().toString());
				return UriComponentsBuilder.fromUriString(targetUrl).queryParam("token", token).build().toUriString();
			}

			String token = tokenProvider.createToken(((UserPrincipal) userDetails).getId().toString());
			return UriComponentsBuilder.fromUriString(targetUrl).queryParam("token", token).build().toUriString();
		}

		return "#";
	}

	private String getRegistrationId(Authentication authentication) {
		return ((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId();
	}

	private boolean isOAuth2Provider(Authentication authentication) {
		OAuth2AuthenticationToken authenticationToken = (OAuth2AuthenticationToken) authentication;
		return !authenticationToken.getAuthorizedClientRegistrationId().equals("local");
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
		super.clearAuthenticationAttributes(request);
		httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
	}

	private boolean isAuthorizedRedirectUri(String uri) {
		URI clientRedirectUri = URI.create(uri);

		return appProperties.getOauth2().getAuthorizedRedirectUris().stream().anyMatch(authorizedRedirectUri -> {
			// Only validate host and port. Let the clients use different paths if they want to
			URI authorizedURI = URI.create(authorizedRedirectUri);
			if (authorizedURI.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
					&& authorizedURI.getPort() == clientRedirectUri.getPort()) {
				return true;
			}
			return false;
		});
	}
}