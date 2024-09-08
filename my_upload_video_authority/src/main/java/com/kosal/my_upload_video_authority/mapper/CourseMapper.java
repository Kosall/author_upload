package com.kosal.my_upload_video_authority.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kosal.my_upload_video_authority.entities.Course;
import com.kosal.my_upload_video_authority.entities.DTO.CourseDTO;
import com.kosal.my_upload_video_authority.services.CategoryService;

@Mapper(componentModel = "spring",uses= {CategoryService.class})
public interface CourseMapper {
	CourseMapper INSTANCE=Mappers.getMapper(CourseMapper.class);
	@Mapping(target = "category.id",source = "categoryId")
	Course toCourse(CourseDTO courseDTO);
	@Mapping(target = "categoryId",source = "category.id")
	CourseDTO toCourseDTO(Course course);

}
