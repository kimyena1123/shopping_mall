package com.yena.shopping.product.review;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yena.shopping.product.review.bo.ReviewBO;

@RequestMapping("/review")
@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	//review 작성 API
	@PostMapping("/write")
	public Map<String, Boolean> insertReview(
			HttpSession session
			,@RequestParam("productId") int productId
			,@RequestParam("comment") String comment){
		
		int userId = (Integer)session.getAttribute("session_index");
		int count = reviewBO.insertReview(userId, productId, comment);
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", true);
		}else {
			result.put("result", false);
		}
		
		return result;
	}
}
