package online.testing.user.dto;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import online.testing.user.model.user.User;
import online.testing.user.model.user.impl.UserFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserPrincipal implements OAuth2User, UserDetails {
	private static SimpleGrantedAuthority ROLE_USER = new SimpleGrantedAuthority("ROLE_USER");;
	private String id;
	private String username;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private Map<String, Object> attributes;
        private String role = "ROLE_USER";

	private UserPrincipal(String id, String email, String password) {
		this.id = id.toString();
		this.email = email;
		this.username = email;
		this.password = password;
	}
        
        private UserPrincipal(String id, String email, String password, String role) {
		this.id = id.toString();
		this.email = email;
		this.username = email;
		this.password = password;
                this.role =role;
	}

	private UserPrincipal(String email, Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes) {
		this.email = email;
		this.authorities = authorities;
		this.attributes = attributes;
	}
        
	private static UserPrincipal create(User user, Collection<? extends GrantedAuthority> authorities,
			Map<String, Object> attributes) {
            UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getEmail(), user.getPassword(),user.getRole());
//		UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getEmail(), user.getPassword());
                System.out.println("58 Singleton1!!!");
		if (authorities.isEmpty()) {
			authorities = Collections.
					singletonList(ROLE_USER);
		}
		userPrincipal.setAuthorities(authorities);
		userPrincipal.setAttributes(attributes);
                System.out.println("User principal get Role from Create");
                System.out.println(userPrincipal.getRole());
		return userPrincipal;
	}

	public static UserPrincipal create(User user, Map<String, Object> attributes) {
		UserPrincipal userPrincipal = UserPrincipal.create(user);
		userPrincipal.setAttributes(attributes);
		return userPrincipal;
	}

	public static UserPrincipal create(Object principal) {
		if (principal instanceof DefaultOidcUser) {
			DefaultOidcUser user = (DefaultOidcUser) principal;
                        UserPrincipal userPrincipal = new UserPrincipal(user.getEmail(), user.getAuthorities(), user.getAttributes());
			//without role
                        //UserPrincipal userPrincipal = new UserPrincipal(user.getEmail(), user.getAuthorities(), user.getAttributes());
			return create(UserFactory.create(userPrincipal, "local"));
		}
		if (principal instanceof User) {
                    System.out.println("User Class!!!");
			User user = (User) principal;
			return create(user, Collections.emptyList(), user.getAttributes());
		}
		return (UserPrincipal) principal;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getName() {
		return String.valueOf(id);
	}
}
