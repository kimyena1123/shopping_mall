package com.yena.shopping.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.order.model.Order;

@Repository
public interface OrderDAO {

	//주문 insert api
	public int orderInsert(
			@Param("userId") int userId
			,@Param("userName") String usrName
			,@Param("address") String address
			,@Param("phone_number") String phone_number
			,@Param("total_price") int total_price
			,@Param("card_name") String card_name);
	
}
