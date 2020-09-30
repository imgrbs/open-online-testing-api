package online.testing.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest extends UserPrincipal {
	@NotBlank
	private String name;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	@Override
	public <A> A getAttribute(String name) {
		return null;
	}
}
