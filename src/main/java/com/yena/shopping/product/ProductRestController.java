package com.yena.shopping.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yena.shopping.product.bo.ProductBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;
@RequestMapping("/product")
@RestController
public class ProductRestController {
	
	@Autowired
	private ProductBO productBO;
	
	@PostMapping("/insert")
	public Map<String, Boolean> product_insert(
			HttpSession session
			,@RequestParam("categoryId") int categoryId
			,@RequestParam("title") String title
			,@RequestParam("price") String price){
		
		int userId = (Integer)session.getAttribute("session_index");
		
		int count = productBO.product_insert(userId, categoryId, title, price);
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", true);
			System.out.println();
		}else {
			result.put("result", false);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
}
