package com.yena.shopping.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yena.shopping.product.bo.ProductBO;
import com.yena.shopping.product.model.Product_Other;

@RequestMapping("/product")
@Controller
public class ProductController {
	
	@Autowired
	private ProductBO productBO;
	
	//메인 화면 view
	@GetMapping("/main/view")
	public String mainView() {
		return "product/main";
	}
	
	//상품 목록 화면
	@GetMapping("/productItem/view")
	public String productItem(Model model
							, HttpSession session) {
		
		//int userId = (Integer)session.getAttribute("session_index");
		
		List<Product_Other> product_OtherList = productBO.getItemInfo();

		model.addAttribute("product_OtherList", product_OtherList);
		
		return "product/item";
	}
	
	//상품 목록 화면

	/*
		@GetMapping("/productItem/view")
		public String productItem(Model model) {
			
			List<Product> produtList = productBO.showProduct();
			model.addAttribute("produtList", produtList);
			return "product/item";
		}*/

	//상품 등록 화면
	@GetMapping("/upload/view")
	public String productView() {
		return "product/productUpload";
	}
	
	
	
	
	
	
	
	
	
}
