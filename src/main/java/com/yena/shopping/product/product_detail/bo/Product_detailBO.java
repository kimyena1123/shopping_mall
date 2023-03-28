package com.yena.shopping.product.product_detail.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.shopping.product.product_detail.dao.Product_detailDAO;

@Service
public class Product_detailBO {

	@Autowired
	private Product_detailDAO product_detailDAO;
	
	//product_detail insert
	public int product_detailInsert(int productId
									,String color
									,String size
									,String desc) {
		
		return product_detailDAO.product_detailInsert(productId, color, size, desc);
	}
}
