package com.springBootBoard.test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDTO {

	private String name;
	
	public static void main(String[] args) {
		TestDTO dto = new TestDTO();
		
		dto.setName("lombok test");
		System.out.println(dto.getName());
	}
}