package com.yena.shopping.product.product_imgs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.product.product_imgs.model.Product_imgs;

@Repository
public interface Product_imgsDAO {

	//관리자 product_imgs insert
	public int insertProductImgs(
			@Param("productId") int productId
			,@Param("imagePath1") String imagePath1
			,@Param("imagePath2") String imagePath2
			,@Param("imagePath3") String imagePath3
			,@Param("imagePath4") String imagePath4);
	
	//product 테이블의 id를 기반으로 조회
	public List<Product_imgs> readProductImgs(@Param("id") int id);
	
	//item.jsp에서 목록을 누르면 해당 상품의 디테일 페이지에 들어갈 사진들을 select
	public List<Product_imgs> showImgs(@Param("productId") int productId);
	
	
}
