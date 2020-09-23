package com.depa.user.security.service;

import java.util.NoSuchElementException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.depa.user.dto.UserPrincipal;
import com.depa.user.model.user.User;
import com.depa.user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) {
	    try {
            User user = userRepository.findByEmail(email).get();
		    return UserPrincipal.create(user);
        } catch (NoSuchElementException e) {
	        return null;
        }
	}

	@Transactional
	public UserDetails loadUserById(ObjectId id) {
		User user = userRepository.findById(id).get();
		return UserPrincipal.create(user);
	}
}
