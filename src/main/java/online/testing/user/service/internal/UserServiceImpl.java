package online.testing.user.service.internal;

import java.util.Map;
import java.util.Optional;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import online.testing.user.model.user.impl.UserImpl;
import online.testing.user.repository.UserRepository;
import online.testing.user.service.UserService;

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

    public Optional<UserImpl> getUser(Authentication authentication) {
        mapAuthentication(authentication);
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
