package com.yena.shopping.category.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.category.model.Category;

@Repository
public interface CategoryDAO {

	//cateogyr 정보 넘기기
	public Category selectCategoryById(@Param("id") int id);
	
	//모든 행의 category 정보 보여주기
	public List<Category> selectCategory();

	
}
