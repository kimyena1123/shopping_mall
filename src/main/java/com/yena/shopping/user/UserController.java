package com.yena.shopping.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

	//회원가입 화면
	@GetMapping("/signup/view")
	public String signupView() {
		
		return "user/signup";
	}
	
	//로그인 화면
	@GetMapping("/signin/view")
	public String signinView() {
		
		return "user/signin";
	}
}
