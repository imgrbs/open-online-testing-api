package com.depa.user.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
public class OAuth2Configuration extends WebSecurityConfigurerAdapter {

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${google.client-id}")
    private String googleClientId;
    @Value("${google.client-secret}")
    private String googleClientSecret;

    @Value("${facebook.client-id}")
    private String facebookClientId;
    @Value("${facebook.client-secret}")
    private String facebookClientSecret;

    private static final String[] WHITELIST = {
            "/oauth2/**",
            "/exams/**",
            "/questions/**",
    };

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().disable();

        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login(oauth -> {
                    oauth.clientRegistrationRepository(this.clientRegistrationRepository());
                    oauth.defaultSuccessUrl("/oauth2/token");
                    oauth.failureUrl("/oauth2/failed");
                });
    }

    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(
                this.depaClientRegistration(),
                this.googleClientRegistration()
                // this.facebookClientRegistration()
        );
    }

    private ClientRegistration depaClientRegistration() {
        return ClientRegistration.withRegistrationId("depa")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .clientName("Depa")
                .clientId("depa-client")
                .authorizationUri(baseUrl + "/oauth2/auth")
                .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
                .tokenUri("{baseUrl}/oauth2/token")
                .tokenUri(baseUrl + "/oauth2/token")
                .build();
    }

    private ClientRegistration googleClientRegistration() {
        return CommonOAuth2Provider.GOOGLE
                .getBuilder("google")
                .clientId(googleClientId)
                .clientSecret(googleClientSecret)
                .build();
    }

    private ClientRegistration facebookClientRegistration() {
        return CommonOAuth2Provider.FACEBOOK
                .getBuilder("facebook")
                .clientId(facebookClientId)
                .clientSecret(facebookClientSecret)
                .build();
    }
}
