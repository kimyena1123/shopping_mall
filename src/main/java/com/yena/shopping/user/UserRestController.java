package com.yena.shopping.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yena.shopping.user.bo.UserBO;
import com.yena.shopping.user.model.User;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userBO;

	//회원가입 API
	@PostMapping("/signup")
	public Map<String, Boolean> singup(
			@RequestParam("user_id") String user_id
			,@RequestParam("user_pw") String user_pw
			,@RequestParam("user_name") String user_name
			,@RequestParam("user_birth") String user_birth
			,@RequestParam("user_email") String user_email
			,@RequestParam("user_address") String user_address
			,@RequestParam("user_number") String user_number){
		
		int count = userBO.signup(user_id, user_pw, user_name, user_birth, user_email, user_address, user_number);
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", true);
		}else {
			result.put("result", false);
		}
		
		return result;
	}
	
	//회원가입 시 아이디 중복검사 API
	@PostMapping("/signup/idCheck")
	public Map<String, Boolean> idCheck(
			@RequestParam("user_id") String user_id){
		//userBO.idCheck(user_id == true : 중복X => 사용 가능
		
		boolean result = userBO.idCheck(user_id);
		
		Map<String, Boolean> id = new HashMap<>();
		
		if(result) {
			id.put("id", true);
		}else {
			id.put("id", false);
		}
		
		return id;
	}
	
	//회원가입시 이메일 중복검사 API
	@PostMapping("/signup/emailCheck")
	public Map<String, Boolean> emailCheck(
			@RequestParam("user_email") String user_email){
		
		boolean result = userBO.emailCheck(user_email);
		
		Map<String, Boolean> email = new HashMap<>();
		
		if(result) {
			email.put("email", true);
		}else {
			email.put("email", false);
		}
		
		return email;
	}
	
	//로그인 API
	@PostMapping("/signin")
	public Map<String, Boolean> signin(
			@RequestParam("user_id") String user_id
			,@RequestParam("user_pw") String user_pw
			,HttpServletRequest request){
	
		User user = userBO.signin(user_id, user_pw);
		
		Map<String, Boolean> result = new HashMap<>();
		
		//조회가 안된다면 null
		if(user != null) {
			result.put("result", true);
			
			//세션 객체 얻어오기
			HttpSession session = request.getSession();
			
			session.setAttribute("session_index", user.getId());
			session.setAttribute("session_name", user.getUser_name());
		}else {
			result.put("result", false);
		}
		
		return result;
	}
}
