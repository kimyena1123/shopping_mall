package com.yena.shopping.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yena.shopping.category.bo.CategoryBO;
import com.yena.shopping.category.model.Category;
import com.yena.shopping.product.bo.ProductBO;
import com.yena.shopping.product.model.Product;
import com.yena.shopping.product.model.Product_Other;
import com.yena.shopping.product.product_imgs.bo.Product_imgsBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;

@RequestMapping("/product")
@Controller
public class ProductController {
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private CategoryBO categoryBO;
	
	@Autowired
	private Product_imgsBO product_imgsBO;
	
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
		
		//product 테이블과 category type 정보 묶어서 show
		List<Product_Other> product_OtherList = productBO.getItemInfo();
		model.addAttribute("product_OtherList", product_OtherList);
		
		List<Category> categoryList = categoryBO.selectCategory();
		model.addAttribute("categoryList", categoryList);
		
		return "product/item";
	}
	
	//고객 아이템 목록 화면
	@GetMapping("/showItemList")
	public String showItemList(Model model
								, HttpSession session) {
		
	//int userId = (Integer)session.getAttribute("session_index");
		
		//product 테이블과 category type 정보 묶어서 show
		List<Product_Other> product_OtherList = productBO.getItemInfo();
		model.addAttribute("product_OtherList", product_OtherList);
		
		List<Category> categoryList = categoryBO.selectCategory();
		model.addAttribute("categoryList", categoryList);
		
		return "product/showItem";
	}
	
	//상품 등록 화면
	@GetMapping("/upload/view")
	public String productView(Model model) {
		List<Category> categoryList = categoryBO.selectCategory();
		model.addAttribute("categoryList", categoryList);
		
		int productCount = productBO.productCount();
		model.addAttribute("productCount", productCount);
	
		List<Product> productList = productBO.sendProductId();
		model.addAttribute("productList", productList);
		
		return "product/productUpload";
	}
	
	
	
	
	
	
	
	
	
	
}
