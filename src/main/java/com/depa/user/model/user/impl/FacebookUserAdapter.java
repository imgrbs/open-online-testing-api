package com.depa.user.model.user.impl;

import java.util.Map;

import org.bson.types.ObjectId;

import com.depa.user.model.user.User;
import com.depa.user.security.config.AuthProvider;

public class FacebookUserAdapter implements User {
	private static UserImpl user;

	public static User create(String email) {
		user = UserImpl.create(email);
		user.setProvider(AuthProvider.facebook);
		return user;
	}

	@Override
	public String getEmail() {
		return user.getEmail();
	}

    @Override
    public String getId() {
        return null;
    }
	@Override
	public void setEmail(String email) {
        user.setEmail(email);
	}

	@Override
	public String getDisplayName() {
		return user.getDisplayName();
	}

	@Override
	public String getAuthProvider() {
		return user.getAuthProvider();
	}

	@Override
	public ObjectId getId() {
		return user.getId();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public void setPassword(String password) {
        user.setPassword(password);
	}

	@Override
	public String getProvider() {
		return user.getProvider();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public void setUsername(String username) {
        user.setUsername(username);
	}

	@Override
	public void setProviderId(String providerId) {
        user.setProviderId(providerId);
	}

	@Override
	public void setName(String name) {
        user.setName(name);
	}

	@Override
	public void setImageUrl(String imageUrl) {
        user.setImageUrl(imageUrl);
	}

	@Override
	public Map<String, Object> getAttributes() {
		return user.getAttributes();
	}

	@Override
	public void setAttributes(Map<String, Object> attributes) {
		user.setAttributes(attributes);
	}
}
