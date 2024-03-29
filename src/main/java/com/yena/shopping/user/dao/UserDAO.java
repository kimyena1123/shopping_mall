package com.yena.shopping.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.user.model.User;

@Repository
public interface UserDAO {

	//회원가입
	public int signup(
			@Param("user_id") String user_id
			,@Param("user_pw") String user_pw
			,@Param("user_email") String user_email
			,@Param("user_name") String user_name
			,@Param("user_birth") String user_birth
			,@Param("user_address") String user_address
			,@Param("user_number") String user_number);
	
	//아이디 중복 검사
	public int idCheck(@Param("user_id") String user_id);
	
	//이메일 중복 검사
	public int emailCheck(@Param("user_email") String user_email);
	
	//로그인
	public User signin(@Param("user_id") String user_id
						, @Param("user_pw") String user_pw);
	
	//user 테이블의 id를 받아서 해당 id의 정보(행) 보내기
	public User sendUserInfoById(@Param("id") int id);
}
