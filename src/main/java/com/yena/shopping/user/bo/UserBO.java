package com.yena.shopping.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.shopping.common.EncryptUtils;
import com.yena.shopping.user.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;

	//회원가입
	public int signup(
			String user_id, String user_pw
			,String user_name, String user_birth
			,String user_email, String user_address
			,String user_number) {
		
		//비밀번호 암호화
		String encryptPassword = EncryptUtils.md5(user_pw);
		
		//넘겨줄 때 user_pw가 아닌 암호화된 encryptPassword로 넘겨준다.
		return userDAO.signup(user_id, encryptPassword, user_email, user_name, user_birth, user_address, user_number);
	}
	
	//아이디 중복 검사
	public boolean idCheck(String user_id) {
		
		int count = userDAO.idCheck(user_id);
		
		//count == 1이라면 중복
		//count == 0이라면 중복 없음
		
		if(count == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//이메일 중복 검사
	public boolean emailCheck(String user_email) {
		
		int count = userDAO.emailCheck(user_email);
		
		//count == 1이라면 중복
		//count == 0이라면 중복x
		
		if(count == 0) {
			return true;
		}else {
			return false;
		}
	}
}
