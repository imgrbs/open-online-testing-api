package online.testing.user.model.user;

import java.util.Map;

import org.bson.types.ObjectId;

public interface User {

    String getEmail();

    String getDisplayName();

    String getAuthProvider();

    String getId();

    String getPassword();

    void setPassword(String password);

    String getProvider();

    String getUsername();

    void setProviderId(String providerId);

    void setName(String name);

    void setUsername(String username);

    void setEmail(String email);

    void setImageUrl(String imageUrl);

    Map<String, Object> getAttributes();

    void setAttributes(Map<String, Object> attributes);
}
