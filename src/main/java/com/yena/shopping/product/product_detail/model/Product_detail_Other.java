package com.yena.shopping.product.product_detail.model;

import java.util.Date;
import java.util.List;

import com.yena.shopping.product.product_imgs.model.Product_imgs;

public class Product_detail_Other {

	//product_detail 테이블 정보 
	private int id;
	private int productId;
	private String color;
	private String size;
	private String desc;
	private Date createdAt;
	private Date updatedAt;
	
	//product 테이블 정보
	private String title;
	private String price;
	
	//product_imgs 테이블 정보
	//private String product_img;
	private List<Product_imgs> imgList;
		
	
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
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public List<Product_imgs> getImgList() {
		return imgList;
	}

	public void setImgList(List<Product_imgs> imgList) {
		this.imgList = imgList;
	}


	
}
