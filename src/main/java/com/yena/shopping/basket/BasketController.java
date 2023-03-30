package com.yena.shopping.basket;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yena.shopping.basket.bo.BasketBO;
import com.yena.shopping.basket.model.BasketOther;

@RequestMapping("/basket")
@Controller
public class BasketController {
	
	@Autowired
	private BasketBO basketBO;

	//장바구니 페이지
	@GetMapping("/totalOrder")
	public String basketPageView(
			HttpSession session
			,Model model) {
		
		int userId = (Integer)session.getAttribute("session_index");
		
		
		List<BasketOther> basketList = basketBO.getBasketInfo(userId);
		model.addAttribute("basketList", basketList);
		
		int countNum = basketBO.selectCountList(userId);
		model.addAttribute("countNum", countNum);
		
		return "basket/basketOrder";
	}
}
