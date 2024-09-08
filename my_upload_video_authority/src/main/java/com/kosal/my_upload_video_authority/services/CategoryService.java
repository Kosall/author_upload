package com.kosal.my_upload_video_authority.services;

import java.util.List;

import com.kosal.my_upload_video_authority.entities.Category;

public interface CategoryService {
	Category create(Category category);
	Category getCategoryById(Long id);
	List<Category>getAllCategories();
	Category update(Category category,Long id);
	void delete(Long id);

}
