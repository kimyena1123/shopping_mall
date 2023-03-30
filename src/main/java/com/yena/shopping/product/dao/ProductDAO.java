package com.yena.shopping.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.product.model.Product;

@Repository
public interface ProductDAO {

	public List<Product> selectProductInfo();
	
	//관리자 product insert
	public int product_insert(
			@Param("userId") int userId
			,@Param("categoryId") int categoryId
			,@Param("title") String title
			,@Param("price") String price);
	
	//현재 product의 개수 send
	public int sendProductCount();
	
	//product 테이블의 id를 기반으로 product를 조회
	public Product readProduct(@Param("id") int id);
	
	
}
