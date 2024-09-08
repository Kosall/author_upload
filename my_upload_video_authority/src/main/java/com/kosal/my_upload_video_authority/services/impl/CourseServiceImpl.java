package com.kosal.my_upload_video_authority.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosal.my_upload_video_authority.Repositories.CourseRepository;
import com.kosal.my_upload_video_authority.entities.Category;
import com.kosal.my_upload_video_authority.entities.Course;
import com.kosal.my_upload_video_authority.exception.ResourceNotFound;
import com.kosal.my_upload_video_authority.services.CourseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{
	
	private final CourseRepository repository;
	@Override
	public Course create(Course course) {
		// TODO Auto-generated method stub
		return repository.save(course);
	}
	
	@Override
	public Course getById(Long id) {
		
		return repository.findById(id).orElseThrow(()->new ResourceNotFound("course", id));
	}

	/*
	 * @Override public List<Course> getCourses() { // TODO Auto-generated method
	 * stub return repository.findAll(); }
	 */
	@Override
	public Course update(Course courseForUpdate, Long id) {
		Course newCourse = getById(id);
		newCourse.setName(courseForUpdate.getName());
		return repository.save(newCourse);
		
	}
	@Override
	public void delete(Long id) {
		Course course = getById(id);
		repository.delete(course);
		
	}

	@Override
	public List<Course> getCourseByCategoryId(Long id) {
	
		List<Course> courseByCategoryId = getCourseByCategoryId(id);
		// TODO Auto-generated method stub
		return  repository.findAll();
	}
	
	

}
