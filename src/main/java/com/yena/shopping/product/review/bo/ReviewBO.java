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
		
		List<Review> reviewList = reviewDAO.selectAllReview(productId);
		
		List<ReviewOther> reviewOtherList = new ArrayList<>();
		
		for(Review review:reviewList) {
			ReviewOther reviewOther = new ReviewOther();
			
			reviewOther.setId(review.getId());
			reviewOther.setUserId(review.getUserId());
			reviewOther.setProductId(review.getProductId());
			reviewOther.setComment(review.getComment());
			reviewOther.setCreatedAt(review.getCreatedAt());
		
			//user 테이블에 대한 정보
			User user = userBO.sendUserInfoById(review.getUserId());
			reviewOther.setUser_name(user.getUser_name());
			
			//product 테이블에 대한 정보
			Product product = productBO.getProduct(productId);
			reviewOther.setProduct_title(product.getTitle());
			reviewOther.setProduct_price(product.getPrice());
			
			//review_imgs 테이블에 대한 정보
			List<Review_imgs> reviewImgList = review_imgsBO.sendReview_imgs(review.getId());
			reviewOther.setReview_imgsList(reviewImgList);
			
			Review_imgs review_imgs = review_imgsBO.oneReviewImg(review.getId());
			//reviewOther.setReviewImgs_img(review_imgs.getReview_img());
			
			if(review_imgs == null) {
				System.out.println("reviewId가 >>" + review.getId());
			}else {
				reviewOther.setReviewImgs_img(review_imgs.getReview_img());
				System.out.println("reviewId가 >> " + review.getId() + "일 때 >> " + review_imgs.getReview_img());
			}
			
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
	
	//review detail page
	public ReviewOther sendReviewOtherInfo(int reviewId) {
		Review review = reviewDAO.sendReviewInfo(reviewId);
		ReviewOther reviewOther = new ReviewOther();
		
		reviewOther.setId(review.getId());
		reviewOther.setUserId(review.getUserId());
		reviewOther.setProductId(review.getProductId());
		reviewOther.setComment(review.getComment());
		reviewOther.setCreatedAt(review.getCreatedAt());
		
		//user 테이블에 대한 정보
		User user = userBO.sendUserInfoById(review.getUserId());
		reviewOther.setUser_name(user.getUser_name());
		
		//product 테이블에 대한 정보
		Product product = productBO.getProduct(review.getProductId());
		reviewOther.setProduct_title(product.getTitle());
		
		//review_imgs 테이블에 대한 정보
		List<Review_imgs> imgList = review_imgsBO.sendReview_imgs(reviewId);
		reviewOther.setReview_imgsList(imgList);
		
		return reviewOther;
	}
}
