package com.yena.shopping.product.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.shopping.category.bo.CategoryBO;
import com.yena.shopping.category.model.Category;
import com.yena.shopping.product.dao.ProductDAO;
import com.yena.shopping.product.model.Product;
import com.yena.shopping.product.model.Product_Other;

@Service
public class ProductBO {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryBO categoryBO; // category 테이블 정보를 가져오기 위해서

	
	public List<Product> showProduct(){
		return productDAO.selectProductInfo();
	}
	
	//상품 리스트 
	// product 정보에 categoryid를 가져와 정보 알려주기
	public List<Product_Other> getItemInfo(){
		
		List<Product> productList = productDAO.selectProductInfo();
		List<Product_Other> product_OtherList = new ArrayList<>();
		
		//product 한 개 마다 그에 해당하는 category 정보 가져오기
		for(Product product:productList) {
			
			Product_Other product_other = new Product_Other();
			
			product_other.setId(product.getId());
			product_other.setTitle(product.getTitle());
			product_other.setPrice(product.getPrice());
			
			//product 테이블의 categoryId와 category의 id를 대조해서
			//category 테이블의 정보를 가져옴
			Category category = categoryBO.getCategoryById(product.getCategoryId());
			product_other.setType(category.getType());
			
			
			product_OtherList.add(product_other);
		}
		return product_OtherList;
		
	}
	
	
	//관리자 product insert
	public int product_insert(int userId, int categoryId
							,String title, String price) {
		return productDAO.product_insert(userId, categoryId, title, price);
	}
	
	//현재 product 개수 send
	public int productCount() {
		return productDAO.sendProductCount();
	}
	
	//productId를 보내주기 위함
	public List<Product> sendProductId(){
		return productDAO.selectProductInfo();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
