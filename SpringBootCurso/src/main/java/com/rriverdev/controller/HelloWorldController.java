package com.rriverdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String helloWorld() {
		  return "hellworld";
	}
}
