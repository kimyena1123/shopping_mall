package com.yena.shopping.product.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yena.shopping.product.product_detail.bo.Product_detailBO;
import com.yena.shopping.product.product_detail.model.Product_detail_Other;
import com.yena.shopping.product.review.bo.ReviewBO;
import com.yena.shopping.product.review.model.Review;
import com.yena.shopping.product.review.model.ReviewOther;

@RequestMapping("/review")
@Controller
public class ReviewController {
	@Autowired
	private ReviewBO reviewBO;
	@Autowired
	private Product_detailBO product_detailBO;

	//review page view
	@GetMapping("/View")
	public String reviewView(
			@RequestParam("productId") int productId
			,Model model) {
		
		List<ReviewOther> reviewList = reviewBO.getReviewInfo(productId);
		model.addAttribute("reviewList", reviewList);
		
		Product_detail_Other productInfos = product_detailBO.showImgs(productId);
		model.addAttribute("productInfos", productInfos);
		
		return "review/reviewPage";
	}
	
	//review write page view
	@GetMapping("/write/view")
	public String writeReviewView(Model model
			,@RequestParam("productId") int productId) {
		
		Product_detail_Other productInfos = product_detailBO.showImgs(productId);
		model.addAttribute("productInfos", productInfos);
		
		Review review = reviewBO.getReviewId(productId);
		model.addAttribute("review", review);
		
		return "review/writeReview";
	}
}
