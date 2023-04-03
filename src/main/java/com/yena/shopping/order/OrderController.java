package com.yena.shopping.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yena.shopping.order.bo.OrderBO;
import com.yena.shopping.order.model.OrderOther;

@RequestMapping("/order")
@Controller
public class OrderController {
	@Autowired
	private OrderBO orderBO;

	//주문 페이지 이동
	@GetMapping("page/view")
	public String orderPageView(
			HttpSession session
			,Model model) {
		
		int userId = (Integer)session.getAttribute("session_index");
		
		List<OrderOther> orderList = orderBO.getORderInfo(userId);
		model.addAttribute("orderList", orderList);
		
		OrderOther orderOther = orderBO.sendUserInfo(userId);
		model.addAttribute("orderOther", orderOther);
		
		return "order/orderPage";
	}
}
