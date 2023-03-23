package com.yena.shopping.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yena.shopping.product.model.Product;

@Repository
public interface ProductDAO {

	public List<Product> selectProductInfo();
}
