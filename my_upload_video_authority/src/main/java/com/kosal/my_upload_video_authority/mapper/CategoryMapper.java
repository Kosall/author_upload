package com.kosal.my_upload_video_authority.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kosal.my_upload_video_authority.entities.Category;
import com.kosal.my_upload_video_authority.entities.DTO.CategoryDTO;

@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE=Mappers.getMapper(CategoryMapper.class);
	
	Category toCategory(CategoryDTO dto);
	CategoryDTO categoryDTO(Category category);
	

}
