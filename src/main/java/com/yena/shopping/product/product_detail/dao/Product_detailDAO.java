package com.yena.shopping.product.product_detail.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_detailDAO {

	//product_detail insert
	public int product_detailInsert(
			@Param("productId") int productId
			,@Param("color") String color
			,@Param("size") String size
			,@Param("desc") String desc);
	

}
