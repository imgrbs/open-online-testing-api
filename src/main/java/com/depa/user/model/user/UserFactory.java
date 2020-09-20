package com.depa.user.model.user;

import com.depa.user.dto.UserPrincipal;
import com.depa.user.model.user.impl.UserImpl;

public class UserFactory {

	public static User create(UserPrincipal userPrincipal, String registrationId) {
		User user;

		switch (registrationId) {
			case "facebook":
			case "google":
			default:
				user = UserImpl.create(userPrincipal.getEmail());
		}

		user.setName(userPrincipal.getAttribute("name"));
		return user;
	}
}
