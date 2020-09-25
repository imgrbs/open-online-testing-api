package com.depa.user.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.depa.user.dto.ApiResponse;
import com.depa.user.dto.AuthResponse;
import com.depa.user.dto.LoginRequest;
import com.depa.user.dto.SignUpRequest;
import com.depa.user.dto.UserPrincipal;
import com.depa.user.model.user.User;
import com.depa.user.model.user.impl.UserFactory;
import com.depa.user.repository.UserRepository;
import com.depa.user.security.exception.BadRequestException;
import com.depa.user.service.TokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TokenProvider tokenProvider;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		String token = tokenProvider.createToken(userPrincipal.getId().toString());
		return ResponseEntity.ok(new AuthResponse(token));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new BadRequestException("Email address already in use.");
		}

		// Creating user's account
		User user = UserFactory.create(signUpRequest, "local");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me").buildAndExpand(result.getId())
				.toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully@"));
	}

}