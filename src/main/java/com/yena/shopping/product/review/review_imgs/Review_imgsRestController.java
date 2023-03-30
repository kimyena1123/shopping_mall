package com.yena.shopping.product.review.review_imgs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yena.shopping.product.review.review_imgs.bo.Review_imgsBO;

@RequestMapping("/review_imgs")
@RestController
public class Review_imgsRestController {
	@Autowired
	private Review_imgsBO review_imgsBO;

	//리뷰 사진들 insert
	@PostMapping("/insert")
	public Map<String, Boolean> insertReview_imgs(
			HttpSession session
			,@RequestParam("review_id") int review_id
			,@RequestParam(value="file1", required=false) MultipartFile file1
			,@RequestParam(value="file2", required=false) MultipartFile file2
			,@RequestParam(value="file3", required=false) MultipartFile file3
			,@RequestParam(value="file4", required=false) MultipartFile file4){
		
		int user_index = (Integer)session.getAttribute("session_index");
		
		int count = review_imgsBO.insertReview_imgs(user_index, review_id, file1, file2, file3, file4);

		Map<String, Boolean> result = new HashMap<>();
		
		if(count < 1) {
			result.put("result", false);
		}else {
			result.put("result", true);
		}
		
		return result;
	}
}
