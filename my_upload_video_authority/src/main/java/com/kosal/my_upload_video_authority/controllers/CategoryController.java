package com.kosal.my_upload_video_authority.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosal.my_upload_video_authority.Repositories.CategoryRepository;
import com.kosal.my_upload_video_authority.entities.Category;
import com.kosal.my_upload_video_authority.entities.Course;
import com.kosal.my_upload_video_authority.entities.DTO.CategoryDTO;
import com.kosal.my_upload_video_authority.mapper.CategoryMapper;
import com.kosal.my_upload_video_authority.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<?>create(@RequestBody CategoryDTO categoryDTO){
		CategoryDTO dto= new CategoryDTO();
		

		Category category=CategoryMapper.INSTANCE.toCategory(dto);
		Category create = categoryService.create(category);
		return ResponseEntity.ok(CategoryMapper.INSTANCE.categoryDTO(create));
		
	}
	@GetMapping("{id}")
	public ResponseEntity<?>getOneCategory(@PathVariable Long id){
		Category category = categoryService.getCategoryById(id);
		return ResponseEntity.ok(category);
	}
	@GetMapping
	public ResponseEntity<?>getAll(){
		 List<CategoryDTO> collect = categoryService.getAllCategories()
				.stream()
				.map(mr->CategoryMapper.INSTANCE.categoryDTO(mr))
				.collect(Collectors.toList());
		return ResponseEntity.ok(collect);
			
	}
	@PutMapping("{id}")
	public ResponseEntity<?>update(@PathVariable Long id,@RequestBody CategoryDTO categoryDTO){
		Category udate = CategoryMapper.INSTANCE.toCategory(categoryDTO);
		Category update = categoryService.update(udate, id);
		return ResponseEntity.ok(CategoryMapper.INSTANCE.categoryDTO(update));
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?>delete(@PathVariable Long id){
		categoryService.delete(id);
		return ResponseEntity.ok().build();
	}
		

}
