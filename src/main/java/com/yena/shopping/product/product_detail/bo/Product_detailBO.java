package com.yena.shopping.product.product_detail.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.shopping.product.bo.ProductBO;
import com.yena.shopping.product.model.Product;
import com.yena.shopping.product.product_detail.dao.Product_detailDAO;
import com.yena.shopping.product.product_detail.model.Product_detail;
import com.yena.shopping.product.product_detail.model.Product_detail_Other;
import com.yena.shopping.product.product_imgs.bo.Product_imgsBO;
import com.yena.shopping.product.product_imgs.model.Product_imgs;

@Service
public class Product_detailBO {

	@Autowired
	private Product_detailDAO product_detailDAO;
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private Product_imgsBO product_imgsBO;
	
	//product_detail insert
	public int product_detailInsert(int productId
									,String color
									,String size
									,String desc) {
		
		return product_detailDAO.product_detailInsert(productId, color, size, desc);
	}
	
	//관리자가 누른 상품의 디테일 보기
	public Product_detail getProduct(int id) {
		return product_detailDAO.readProduct(id);
	}
	
	public Product_detail_Other showImgs(int id){
		
		//해당 id에 맞는 product_detail 정보
		Product_detail product_detail = product_detailDAO.readProduct(id);
		
		Product_detail_Other product_detail_other = new Product_detail_Other();
		
		product_detail_other.setProductId(id);
		
		product_detail_other.setColor(product_detail.getColor());
		product_detail_other.setSize(product_detail.getSize());
		product_detail_other.setDesc(product_detail.getDesc());
		
		//product 테이블 정보
		Product product = productBO.getProduct(id);
		product_detail_other.setTitle(product.getTitle());
		product_detail_other.setPrice(product.getPrice());
		
		//product_imgs 테이블
		//productId(id)를 보내준다
		//해당 id에 해당하는 모든 행들을 가져온다 => List
		List<Product_imgs> imgList = product_imgsBO.getProductImgs(id);
		//가져온 imgList 정보들을 
		product_detail_other.setImgList(imgList);
		
		return product_detail_other;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
