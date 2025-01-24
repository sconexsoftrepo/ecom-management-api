package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import com.sconexsoft.ecom.entity.Category;

public interface CategoryService {
	
	List<Category> getAllCategories();
	Optional<Category> getCategoryById(Long id);
    Category addCategory(Category category);
    Category updateCategory(Category category);
    boolean deleteCategory(Long id);
}