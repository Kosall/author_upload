package com.kosal.my_upload_video_authority.services.impl;

import java.util.List;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.kosal.my_upload_video_authority.Repositories.CategoryRepository;
import com.kosal.my_upload_video_authority.entities.Category;
import com.kosal.my_upload_video_authority.exception.ResourceNotFound;
import com.kosal.my_upload_video_authority.services.CategoryService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService  {
	private final CategoryRepository categoryRepository;

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stu

		
		return categoryRepository.findById(id).orElseThrow(()->new ResourceNotFound("Category", id));
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category update(Category category, Long id) {
		Category cate = getCategoryById(id);
		cate.setName(category.getName());
		return categoryRepository.save(cate);
	}

	@Override
	public void delete(Long id) {
		Category category = getCategoryById(id);
		categoryRepository.delete(category);

		
	}

}
