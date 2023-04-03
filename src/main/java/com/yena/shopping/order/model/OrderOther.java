package com.yena.shopping.order.model;

import java.util.Date;
import java.util.List;

import com.yena.shopping.basket.model.Basket;
import com.yena.shopping.user.model.User;

public class OrderOther {
	
	//order 테이블에 대한 정보
	private int id;
	private int userId;
	private String userName;
	private String address;
	private String phone_number;
	private int total_price;
	private String card_name;
	private Date createdAt;
	private Date updatedAt;
	
	//product 테이블에 대한 정보
	private String title; //상품 제목
	private String price; //상품 가격
	
	//shopping_basket 테이블에 대한 정보
	private int count;
	private int basket_price;
	
	private List<Basket> basketInfonfoList;
	
	//user 테이블에 대한 정보
	private String user_name;
	private String user_address;
	private String user_number;

	//product_imgs 테이블에 대한 정보
	private String productImgs_img;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getBasket_price() {
		return basket_price;
	}

	public void setBasket_price(int basket_price) {
		this.basket_price = basket_price;
	}

	public List<Basket> getBasketInfonfoList() {
		return basketInfonfoList;
	}

	public void setBasketInfonfoList(List<Basket> basketInfonfoList) {
		this.basketInfonfoList = basketInfonfoList;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_number() {
		return user_number;
	}

	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}

	public String getProductImgs_img() {
		return productImgs_img;
	}

	public void setProductImgs_img(String productImgs_img) {
		this.productImgs_img = productImgs_img;
	}

	
	//getters and setters
	
	

}
