package com.yena.shopping.product.review.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.shopping.product.bo.ProductBO;
import com.yena.shopping.product.model.Product;
import com.yena.shopping.product.product_detail.bo.Product_detailBO;
import com.yena.shopping.product.product_detail.model.Product_detail;
import com.yena.shopping.product.review.dao.ReviewDAO;
import com.yena.shopping.product.review.model.Review;
import com.yena.shopping.product.review.model.ReviewOther;
import com.yena.shopping.product.review.review_imgs.bo.Review_imgsBO;
import com.yena.shopping.product.review.review_imgs.model.Review_imgs;
import com.yena.shopping.user.bo.UserBO;
import com.yena.shopping.user.model.User;

@Service
public class ReviewBO {
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private Product_detailBO product_detailBO;
	
	@Autowired
	private Review_imgsBO review_imgsBO;

	//어떤 유저가 올린 리뷰에 여러 정보 보여주기
	public List<ReviewOther> getReviewInfo(int productId){
		
		List<Review> reviewList = reviewDAO.selectAllReview();
		
		List<ReviewOther> reviewOtherList = new ArrayList<>();
		
		for(Review review:reviewList) {
			ReviewOther reviewOther = new ReviewOther();
			
			reviewOther.setId(review.getId());
			reviewOther.setUserId(review.getUserId());
			reviewOther.setComment(review.getComment());
			reviewOther.setCreatedAt(review.getCreatedAt());
			
			//review 테이블의 userId와 user테이블의 id를 대조해서
			//그 해당 id(user 테이블의 id)의 행(정보)를 가져옴
			User user = userBO.sendUserInfoById(review.getUserId());
			reviewOther.setUser_name(user.getUser_name());
			reviewOther.setUser_id(user.getUser_id());
			
			//product 테이블 정보 가져오기
			//product테이블의 id와 매개변수로 받은 productId가 같아야 함
			//같은 해당 행의 정보 가져오기
			Product product = productBO.getProduct(productId);
			reviewOther.setProduct_index(productId);
			reviewOther.setProduct_title(product.getTitle());
			reviewOther.setProduct_price(product.getPrice());
			
			//product_detail 테이블 정보 가져오기
			Product_detail product_detail = product_detailBO.getProduct(productId);
			reviewOther.setProduct_detail_color(product_detail.getColor());
			reviewOther.setProduct_detail_size(product_detail.getSize());
			reviewOther.setProduct_detail_desc(product_detail.getDesc());
			
			//review_imgs 테이블 정보 가져오기
			//review 테이블의 id와 review_imgs 테이블의 reviewId를 대조
			List<Review_imgs> reviewImgList = review_imgsBO.sendReview_imgs(review.getId());
			reviewOther.setReview_imgsList(reviewImgList);
			
			reviewOtherList.add(reviewOther);
			
		}
		return reviewOtherList;
	}
	
	//review write insert
	public int insertReview(int userId, int productId, String comment) {
		return reviewDAO.insertReview(userId, productId, comment);
	}
	
	//productId로 해당 review테이블의 id를 가져오기(가장 마지막 행)
	public Review getReviewId(int productId) {
		return reviewDAO.getReviewId(productId);
	}
}
