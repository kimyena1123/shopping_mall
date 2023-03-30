package com.yena.shopping.basket.model;

import java.util.Date;

public class BasketOther {

	//basket 테이블의 정보
	private int id;
	private int userId;
	private int productId;
	private int count;
	private int price;
	private Date createdAt;
	private Date updatedAt;
	
	//product 테이블의 정보
	private int product_id;
	private String product_title;
	private String product_price;
	
	//product_imgs 테이블의 정보
	private String product_imgs_img;

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProduct_imgs_img() {
		return product_imgs_img;
	}

	public void setProduct_imgs_img(String product_imgs_img) {
		this.product_imgs_img = product_imgs_img;
	}
	
	
}
