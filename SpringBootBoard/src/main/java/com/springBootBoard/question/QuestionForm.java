package com.springBootBoard.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

	@Size(max=200)
	@NotEmpty(message="Please Enter the Subject")
	private String subject;
	
	@NotEmpty(message="Please Enter the Content")
	private String content;
}
