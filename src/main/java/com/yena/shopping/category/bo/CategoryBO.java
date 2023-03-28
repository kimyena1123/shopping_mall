package com.yena.shopping.category.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yena.shopping.category.dao.CategoryDAO;
import com.yena.shopping.category.model.Category;

@Service
public class CategoryBO {
	
	@Autowired
	private CategoryDAO categoryDAO;

	//category 정보 넘기기
	//product 테이블의 categoryId와 category테이블의 id 대조
	// => int id(category 테이블의 id)를 매개변수로 넘겨주는 것임
	public Category getCategoryById(int id) { // 한 행에 대한 정보
		return categoryDAO.selectCategoryById(id);
	}
	
	//모든 행의 category 정보 show
	public List<Category> selectCategory(){
		return categoryDAO.selectCategory();
	}
	
}
