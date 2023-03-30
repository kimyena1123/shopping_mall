package com.yena.shopping.product.product_detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yena.shopping.product.bo.ProductBO;
import com.yena.shopping.product.model.Product;
import com.yena.shopping.product.product_detail.bo.Product_detailBO;
import com.yena.shopping.product.product_detail.model.Product_detail;
import com.yena.shopping.product.product_detail.model.Product_detail_Other;
import com.yena.shopping.product.product_imgs.bo.Product_imgsBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;

@RequestMapping("/product_detail")
@Controller
public class ProductDetailController {

	@Autowired
	private Product_detailBO product_detailBO;
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private Product_imgsBO product_imgsBO;
	
	
	//product detail page view
	//@PostMapping("/detail/view")
	@GetMapping("/detail/view") 
	public String product_detailView(
			@RequestParam("id") int id
			,Model model) {
	
		
		Product_detail_Other productInfos = product_detailBO.showImgs(id);
		model.addAttribute("productInfos",productInfos);
		
		
		
		return "product_detail/product_detailPage";
	}
}
