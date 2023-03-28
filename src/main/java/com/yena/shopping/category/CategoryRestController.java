package com.yena.shopping.category;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yena.shopping.category.bo.CategoryBO;

@RequestMapping("/category")
@RestController
public class CategoryRestController {
	
	@Autowired
	private CategoryBO categoryBO;

	
	
}
