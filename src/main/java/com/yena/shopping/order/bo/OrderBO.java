package com.yena.shopping.order.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.shopping.basket.bo.BasketBO;
import com.yena.shopping.basket.dao.BasketDAO;
import com.yena.shopping.basket.model.Basket;
import com.yena.shopping.order.dao.OrderDAO;
import com.yena.shopping.order.model.OrderOther;
import com.yena.shopping.product.bo.ProductBO;
import com.yena.shopping.product.model.Product;
import com.yena.shopping.product.product_imgs.bo.Product_imgsBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;
import com.yena.shopping.user.bo.UserBO;
import com.yena.shopping.user.model.User;

@Service
public class OrderBO {
	
	@Autowired
	private BasketBO basketBO;
	
	@Autowired
	private BasketDAO basketDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private Product_imgsBO product_imgsBO;

	public List<OrderOther> getORderInfo(int userId){
		List<Basket> basketList = basketDAO.selectBasketInfoById(userId);
		List<OrderOther> orderOtherList = new ArrayList<>();
		
		for(Basket basket:basketList) {
			OrderOther orderOther = new OrderOther();
			
			orderOther.setId(basket.getId());
			//orderOther.setProductId(basket.getProductId());
			
			//product 제품의 이름
			Product product = productBO.getProduct(basket.getProductId());
			orderOther.setTitle(product.getTitle());
			orderOther.setPrice(product.getPrice());
			
			//user 테이블의 정보
			User user = userBO.sendUserInfoById(userId);
			orderOther.setUser_name(user.getUser_name());
			orderOther.setUser_address(user.getUser_address());
			orderOther.setUser_number(user.getUser_number());
			
			//shopping_basket에 대한 정보
			orderOther.setCount(basket.getCount());
			orderOther.setBasket_price(basket.getPrice());
			
			
			//product_imgs 테이블에 대한 정보
			Product_imgs product_imgs = product_imgsBO.sendProductImgsInfo(basket.getProductId());
			orderOther.setProductImgs_img(product_imgs.getProduct_img());
			
			orderOtherList.add(orderOther);
		}
		
		return orderOtherList;
	}
	
	public OrderOther sendUserInfo(int userId) {
		User user = userBO.sendUserInfoById(userId);
		
		OrderOther orderOther = new OrderOther();
		
		//user테이블에 대한 정보
		orderOther.setUser_name(user.getUser_name());
		orderOther.setUser_address(user.getUser_address());
		//orderOther.setPhone_number(user.getUser_number());
		orderOther.setUser_number(user.getUser_number());
		
		return orderOther;
	}
	
	//주문 insert api
	public int orderInsert(int userId, String userName, String address
			,String phone_number, int price, String card_name) {
	
		return orderDAO.orderInsert(userId, userName, address, phone_number, price, card_name);
	}

}