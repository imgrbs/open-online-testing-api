package com.depa.user.service.internal;

import com.depa.user.model.user.User;
import com.depa.user.repository.UserRepository;
import com.depa.user.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final RestTemplate restTemplate;
    private Map<String, String> authAttributes;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getEmail() {
        return this.authAttributes.get("email");
    }

    public Optional<User> getUser(Authentication authentication) {
        mapAuthentication(authentication);
        String displayName = getDisplayName();
        String email = getEmail();
        return userRepository.findByEmail(email);
    }

    private void mapAuthentication(Authentication authentication) {
        Object[] objects = authentication.getAuthorities().toArray();
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> mapped = oMapper.convertValue(objects[0], Map.class);
        this.authAttributes = oMapper.convertValue(mapped.get("attributes"), Map.class);
    }
}
