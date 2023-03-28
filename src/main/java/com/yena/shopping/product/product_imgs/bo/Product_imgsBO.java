package com.yena.shopping.product.product_imgs.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yena.shopping.common.FileManagerService;
import com.yena.shopping.product.product_imgs.dao.Product_imgsDAO;

@Service
public class Product_imgsBO {
	
	@Autowired
	private Product_imgsDAO product_imgsDAO;

	//관리자 prouct imgs insert
	public int insertProductImgs(
			int user_index
			,int productId
			,MultipartFile product_imgs_file1
			,MultipartFile product_imgs_file2
			,MultipartFile product_imgs_file3
			,MultipartFile product_imgs_file4) {
		
		String imagePath1 = FileManagerService.saveFile(user_index, product_imgs_file1);
		String imagePath2 = FileManagerService.saveFile(user_index, product_imgs_file2);
		String imagePath3 = FileManagerService.saveFile(user_index, product_imgs_file3);
		String imagePath4 = FileManagerService.saveFile(user_index, product_imgs_file4);
		
		return product_imgsDAO.insertProductImgs(productId, imagePath1, imagePath2, imagePath3, imagePath4);
		
	}
}
