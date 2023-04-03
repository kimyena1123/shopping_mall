package com.yena.shopping.product.review.review_imgs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.product.review.review_imgs.model.Review_imgs;

@Repository
public interface Review_imgsDAO {

	//review 테이블의 id와 review_imgs의 reviewId 대조
	public List<Review_imgs> sendReview_imgs(@Param("reviewId") int reviewId);
	
	//review_img insert
	public int insertReview_imgs(
			@Param("review_id") int review_id
			,@Param("imagePath1") String imagePath1
			,@Param("imagePath2") String imagePath2
			,@Param("imagePath3") String imagePath3
			,@Param("imagePath4") String imagePath4);
	
	public Review_imgs oneImgs(@Param("reviewId") int reviewId);
}
