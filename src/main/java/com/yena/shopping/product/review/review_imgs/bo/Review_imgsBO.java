package com.yena.shopping.product.review.review_imgs.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yena.shopping.common.FileManagerService;
import com.yena.shopping.product.review.review_imgs.dao.Review_imgsDAO;
import com.yena.shopping.product.review.review_imgs.model.Review_imgs;

@Service
public class Review_imgsBO {
	
	@Autowired
	private Review_imgsDAO review_imgsDAO;

	//review 테이블의 id와 review_imgs 테이블의 reviewId 대조
	public List<Review_imgs> sendReview_imgs(int reviewId){
		return review_imgsDAO.sendReview_imgs(reviewId);
	}
	
	//review img insert
	public int insertReview_imgs(
			int user_index
			,int review_id
			, MultipartFile file1
			,MultipartFile file2
			,MultipartFile file3
			,MultipartFile file4) {
		
		String imagePath1 = FileManagerService.saveFile(user_index, file1);
		String imagePath2 = FileManagerService.saveFile(user_index, file2);
		String imagePath3 = FileManagerService.saveFile(user_index, file3);
		String imagePath4 = FileManagerService.saveFile(user_index, file4);
		
		return review_imgsDAO.insertReview_imgs(review_id, imagePath1, imagePath2, imagePath3, imagePath4);
	}
	
	public Review_imgs oneReviewImg(int reviewId) {
		return review_imgsDAO.oneImgs(reviewId);
	}
}
