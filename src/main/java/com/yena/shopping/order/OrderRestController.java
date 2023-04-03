package com.yena.shopping.order;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yena.shopping.order.bo.OrderBO;

@RequestMapping("/order")
@RestController
public class OrderRestController {
	
	@Autowired
	private OrderBO orderBO;

	//주문 api
	@PostMapping("/insert")
	public Map<String, Boolean> orderInsert(
			HttpSession session
			,@RequestParam("userName") String usrName
			,@RequestParam("address") String address
			,@RequestParam("phone_number") String phone_number
			,@RequestParam("total_price") int total_price
			,@RequestParam("card_name") String card_name){
		
		int userId = (Integer)session.getAttribute("session_index");
		
		Map<String, Boolean> result = new HashMap<>();
		
		int count = orderBO.orderInsert(userId,usrName, address, phone_number, total_price, card_name);
		
		if(count == 1) {
			result.put("result", true);
		}else {
			result.put("result", false);
		}
		return result;
	}
}
