package online.testing.user.model.user.impl;

import java.nio.file.attribute.UserPrincipal;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import online.testing.user.model.user.User;
import online.testing.user.security.config.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Document("users")
@Setter
@Getter
public class UserImpl implements User, UserPrincipal {
    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String imageUrl;
    private String displayName;
    private AuthProvider provider;
    private String providerId;
	private Map<String, Object> attributes;
        
    private String role="ROLE_USER";    

    private UserImpl(String email) {
        this.id = new ObjectId().toHexString();
        this.email = email;
    }

	protected static UserImpl create(String email) {
		UserImpl user = new UserImpl(email);
		user.setProvider(AuthProvider.local);
		return user;
	}

	public String getAuthProvider() {
		return provider.toString();
	}

	public String getProvider() {
		return provider.toString();
	}

}
