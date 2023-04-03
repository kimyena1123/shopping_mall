package com.yena.shopping.basket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.basket.model.Basket;

@Repository
public interface BasketDAO {

	//장바구니 담기(insert)
	public int insertBasket(
			@Param("userId") int userId
			,@Param("productId") int productId
			,@Param("count") int count
			,@Param("price") int price);
	
	//장바구니에 같은 상품이 있는지
	public int isBasket(@Param("productId") int productId
						,@Param("userId") int userId);
	
	//userId
	public List<Basket> selectBasketInfoById(@Param("userId") int userId);
	
	//위에 함수가 총 몇 개인지
	public int selectCountList(@Param("userId") int userId);
	
	public List<Basket> sendBasketInfo(@Param("userId") int userId);
	
	//장바구니 삭제
	public int basketDelete(@Param("basketId") int basketId
							,@Param("userId") int userId);
}
