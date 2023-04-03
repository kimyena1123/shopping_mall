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
import com.yena.shopping.product.product_imgs.bo.Product_imgsBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;

@Service
public class ProductBO {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryBO categoryBO; // category 테이블 정보를 가져오기 위해서

	@Autowired
	private Product_imgsBO product_imgsBO;
	
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
			product_other.setCategoryId(product.getCategoryId());
			
			//product 테이블의 categoryId와 category의 id를 대조해서
			//category 테이블의 정보를 가져옴
			Category category = categoryBO.getCategoryById(product.getCategoryId());
			product_other.setType(category.getType());
		
			
			//product_imgs 테이블에 대한 정보
			Product_imgs product_imgs = product_imgsBO.sendProductImgsInfo(product.getId());
			
			if(product_imgs == null) {
				System.out.println("productId가 " + product.getId() + "일 때 null");
			}else {
				product_other.setProduct_img(product_imgs.getProduct_img());

			}
			
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
	
	//관리자가 누른 상품의 디테일 보기
	public Product getProduct(int id) {
		return productDAO.readProduct(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
