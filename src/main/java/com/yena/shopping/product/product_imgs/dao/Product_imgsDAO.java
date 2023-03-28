package com.yena.shopping.product.product_imgs.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_imgsDAO {

	//관리자 product_imgs insert
	public int insertProductImgs(
			@Param("productId") int productId
			,@Param("imagePath1") String imagePath1
			,@Param("imagePath2") String imagePath2
			,@Param("imagePath3") String imagePath3
			,@Param("imagePath4") String imagePath4);
}
