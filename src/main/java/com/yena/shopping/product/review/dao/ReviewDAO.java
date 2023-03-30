package com.yena.shopping.product.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.product.review.model.Review;

@Repository
public interface ReviewDAO {

	//올린 모든 리뷰들 가져오기
	public List<Review> selectAllReview();
	
	//review table insert 
	public int insertReview(
			@Param("userId") int userId
			,@Param("productId") int productId
			,@Param("comment") String comment);
	
	//productId를 가져와서 review 테이블의 가장 마지막 행의 id 정보 가져오기
	public Review getReviewId(@Param("productId") int productId);
}
