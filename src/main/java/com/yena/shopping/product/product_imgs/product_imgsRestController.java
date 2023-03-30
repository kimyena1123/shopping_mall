package com.yena.shopping.product.product_imgs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yena.shopping.product.product_imgs.bo.Product_imgsBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;

@RequestMapping("/product_imgs")
@RestController
public class product_imgsRestController {
	
	@Autowired
	private Product_imgsBO product_imgsBO;

	//관리자 product 등록 이미지 insert
	@PostMapping("/insert")
	public Map<String, Boolean> insertProductImgs(
			HttpSession session
			,@RequestParam("productId") int productId
			,@RequestParam(value="product_imgs_file1", required=false) MultipartFile product_imgs_file1
			,@RequestParam(value="product_imgs_file2", required=false) MultipartFile product_imgs_file2
			,@RequestParam(value="product_imgs_file3", required=false) MultipartFile product_imgs_file3
			,@RequestParam(value="product_imgs_file4", required=false) MultipartFile product_imgs_file4){
		
		int user_index = (Integer)session.getAttribute("session_index");
		
		int count = product_imgsBO.insertProductImgs(user_index, productId, product_imgs_file1, product_imgs_file2, product_imgs_file3, product_imgs_file4);
		
		Map<String, Boolean> result = new HashMap<>();
		
		System.out.println("count확인하기(image테이블) >> "+ count);
		
		if(count < 1) {
			result.put("result", false);
		}else {
			result.put("result", true);
		}
		
		return result;
	}
	
	

}
