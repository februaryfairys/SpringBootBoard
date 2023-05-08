package com.springBootBoard.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {

	@Size (min = 3, max = 25)
	@NotEmpty(message = "Please Enter the ID.")
	private String username;
	
	@NotEmpty(message = "Please Enter the Password.")
	private String password;
	
	@NotEmpty(message = "Please Check the Password.")
	private String passwordCheck;
	
	@Email
	@NotEmpty(message = "Please Enter the Email.")
	private String email;
}
