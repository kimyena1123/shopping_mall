package com.yena.shopping.product.review.model;

import java.util.Date;
import java.util.List;

import com.yena.shopping.product.review.review_imgs.model.Review_imgs;

public class ReviewOther {
	//review 테이블에 대한 정보
	private int id;
	private int userId;
	private int productId;
	private String comment;
	private Date createdAt;
	private Date updatedAt;
	
	//user 테이블에 대한 정보
	private String user_name;
	private String user_id;	

	//product 테이블에 대한 정보
	private int product_index;
	private String product_title;
	private String product_price;
	
	//product_detail 테이블에 대한 정보
	private String product_detail_color;
	private String product_detail_size;
	private String product_detail_desc;
	
	//review_imgs 테이블에 대한 정보
	private List<Review_imgs> review_imgsList;
	
	
	//getters and setters
	
	
	public int getUserId() {
		return userId;
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

	public String getProduct_detail_color() {
		return product_detail_color;
	}

	public void setProduct_detail_color(String product_detail_color) {
		this.product_detail_color = product_detail_color;
	}

	public String getProduct_detail_size() {
		return product_detail_size;
	}

	public void setProduct_detail_size(String product_detail_size) {
		this.product_detail_size = product_detail_size;
	}

	public String getProduct_detail_desc() {
		return product_detail_desc;
	}

	public void setProduct_detail_desc(String product_detail_desc) {
		this.product_detail_desc = product_detail_desc;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getProduct_index() {
		return product_index;
	}

	public void setProduct_index(int product_index) {
		this.product_index = product_index;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Review_imgs> getReview_imgsList() {
		return review_imgsList;
	}

	public void setReview_imgsList(List<Review_imgs> review_imgsList) {
		this.review_imgsList = review_imgsList;
	}
	
	
}
