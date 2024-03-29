package com.yena.shopping.product.product_detail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yena.shopping.product.product_detail.bo.Product_detailBO;
import com.yena.shopping.product.product_imgs.bo.Product_imgsBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;

@RequestMapping("/product_detail")
@RestController
public class ProductDetailRestController {
	
	@Autowired
	private Product_detailBO product_detailBO;
	
	@Autowired
	private Product_imgsBO product_imgsBO;

	
	@PostMapping("/insert")
	public Map<String, Boolean> product_detailInsert(
			@RequestParam("productId") int productId
			,@RequestParam("color") String color
			,@RequestParam("size") String size
			,@RequestParam("desc") String desc){
		
		int count = product_detailBO.product_detailInsert(productId, color, size, desc);
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", true);
		}else {
			result.put("result", false);
		}
		
		return result;
	}
	

	
}
