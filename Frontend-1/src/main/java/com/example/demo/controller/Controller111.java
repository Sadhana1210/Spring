package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
@Controller
public class Controller111 {
	@GetMapping("/ss")
	public String index() {
		return "NewFile";
	}
//	@PostMapping("/register")
//	public String register(@ModelAttribute User s) {
//		System.out.println(s.toString());
//		return"NewFile";
//	}
}
