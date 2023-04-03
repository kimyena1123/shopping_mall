package com.yena.shopping.basket.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.shopping.basket.dao.BasketDAO;
import com.yena.shopping.basket.model.Basket;
import com.yena.shopping.basket.model.BasketOther;
import com.yena.shopping.product.bo.ProductBO;
import com.yena.shopping.product.model.Product;
import com.yena.shopping.product.product_imgs.bo.Product_imgsBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;

@Service
public class BasketBO {
	
	@Autowired
	private BasketDAO basketDAO;
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private Product_imgsBO product_imgsBO;

	//장바구니 담기
	public int insertBasket(int userId, int productId, int count, int price) {
		return basketDAO.insertBasket(userId, productId, count, price);
	}
	
	//이미 있는 상품이 장바구니에 있는지 확인
	public boolean isBasket(int userId, int productId) {
		
		int count = basketDAO.isBasket(userId, productId);
		
		if(count == 0) {
			return true; //장바구니 담을 수 있음
		}else {
			return false; // 이미 있다고 알려주기
		}
	}
	
	//현재 유저가 담은 장바구니 목록들 보여주기(하나의 유저가 담은 모든 상품들 List)
	//product 테이블의 title, price
	//product_imgs의 첫번째 사진.
	//shopping_basket 테이블의 count, price
	public List<BasketOther> getBasketInfo(int userId){
		List<Basket> basketList = basketDAO.selectBasketInfoById(userId);
		
		List<BasketOther> basketOtherList = new ArrayList<>();
		
		for(Basket basket:basketList) {
			
			BasketOther basketOther = new BasketOther();
			
			basketOther.setId(basket.getId());
			basketOther.setUserId(basket.getUserId());
			basketOther.setProduct_id(basket.getProductId());
			basketOther.setCount(basket.getCount());
			basketOther.setPrice(basket.getPrice());
			
			//prouct 테이블에 관한 정보
			//basket 테이블의 productId와 product테이블의 id가 같아야함
			Product product = productBO.getProduct(basket.getProductId());
			basketOther.setProduct_title(product.getTitle());
			basketOther.setProduct_price(product.getPrice());
			
			//product_imgs 테이블에 관한 정보
			Product_imgs product_imgs = product_imgsBO.sendProductImgsInfo(basket.getProductId());
			basketOther.setProductImgs_img(product_imgs.getProduct_img());
			System.out.println("id로 가져온 imgs 경로 보기 : " + product_imgs.getProduct_img());
			
			basketOtherList.add(basketOther);
		}
		return basketOtherList;
	}
	
	public int selectCountList(int userId) {
		return basketDAO.selectCountList(userId);
	}
	
	public List<Basket> sendBasketInfo(int userId){
		return basketDAO.sendBasketInfo(userId);
	}
	
	//장바구니 삭제
	public int basketDelete(int userId, int basketId) {
		return basketDAO.basketDelete(basketId, userId);
	}
	
	
	
	
}
