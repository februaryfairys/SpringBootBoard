package com.springBootBoard.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {
		return "This is a test page.";
	}
	
	@ResponseBody
	@GetMapping("/pluginList")
	public String pluginList() {
		return "1. Spring Web | "
				+ "2. Spring Boot Devtools | "
				+ "3. LiveReload++ | "
				+ "4. Lombok | ";
	}
}
