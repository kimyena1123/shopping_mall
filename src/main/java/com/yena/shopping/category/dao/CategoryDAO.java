package com.yena.shopping.category.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yena.shopping.category.model.Category;

@Repository
public interface CategoryDAO {

	//cateogyr 정보 넘기기
	public Category selectCategoryById(@Param("id") int id);
	
	
}
