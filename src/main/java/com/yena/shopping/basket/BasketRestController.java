package com.yena.shopping.basket;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yena.shopping.basket.bo.BasketBO;

@RequestMapping("/basket")
@RestController
public class BasketRestController {
	
	@Autowired
	private BasketBO basketBO;

	//장바구니 insert
	@PostMapping("/insert")
	public Map<String, Boolean> insertBasket(
			HttpSession session
			,@RequestParam("productId") int productId
			,@RequestParam("count") int count
			,@RequestParam("price") int price) {
		
		int userId = (Integer)session.getAttribute("session_index");
		
		int checkCount = basketBO.insertBasket(userId, productId, count, price);
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(checkCount == 1) {
			result.put("result", true);
		}else {
			result.put("result", false);
		}
		
		return result;
	}
	
	//이미 있는 상품이 장바구니에 있는지 확인
	@PostMapping("/isBasket")
	public Map<String, Boolean> isBasket(
			HttpSession session
			,@RequestParam("productId") int productId){
		
		int userId = (Integer)session.getAttribute("session_index");
		
		boolean check = basketBO.isBasket(userId, productId);
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(check) {
			result.put("result", true);
		}else {
			result.put("result", false);
		}
		
		return result;
	}
}
