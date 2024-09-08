package com.kosal.my_upload_video_authority.services;

import java.util.List;

import com.kosal.my_upload_video_authority.entities.Category;
import com.kosal.my_upload_video_authority.entities.Course;

public interface CourseService {
	Course create(Course course);
	Course getById(Long id);
	//List<Course>getCourses();
	List<Course>getCourseByCategoryId(Long id);
	Course update(Course courseForUpdate,Long id);
	void delete(Long id);

}
