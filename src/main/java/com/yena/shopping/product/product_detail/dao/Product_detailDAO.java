package com.yena.shopping.product.product_detail.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.product.product_detail.model.Product_detail;

@Repository
public interface Product_detailDAO {

	//product_detail insert
	public int product_detailInsert(
			@Param("productId") int productId
			,@Param("color") String color
			,@Param("size") String size
			,@Param("desc") String desc);
	
	//product 테이블의 id와 product_detail의 productId를 대조해서 product를 조회
	public Product_detail readProduct(@Param("id") int id);

}
