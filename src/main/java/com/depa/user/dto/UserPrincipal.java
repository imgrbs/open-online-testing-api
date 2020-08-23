package com.depa.user.dto;


import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.depa.user.model.user.User;
import com.depa.user.model.user.impl.UserImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserPrincipal implements OAuth2User, UserDetails {
    private ObjectId id;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    private UserPrincipal(ObjectId id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }


    private static UserPrincipal create(User user, Collection<? extends GrantedAuthority> authorities) {
        UserPrincipal userPrincipal = new UserPrincipal(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );

        if (authorities.isEmpty()) {
            authorities = Collections.
                    singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        userPrincipal.setAuthorities(authorities);

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
            return create(UserImpl.create(user.getEmail()), user.getAuthorities());
        }
        if (principal instanceof User) {
            User user = (User) principal;
            return create(user, Collections.emptyList());
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
