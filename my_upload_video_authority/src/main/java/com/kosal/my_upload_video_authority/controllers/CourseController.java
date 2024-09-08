package com.kosal.my_upload_video_authority.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosal.my_upload_video_authority.entities.Course;
import com.kosal.my_upload_video_authority.entities.DTO.CourseDTO;
import com.kosal.my_upload_video_authority.mapper.CourseMapper;
import com.kosal.my_upload_video_authority.services.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
	private final CourseService courseService;
	@PostMapping
	public ResponseEntity<?>create(@RequestBody CourseDTO courseDTO){
		Course course = CourseMapper.INSTANCE.toCourse(courseDTO);
		Course create = courseService.create(course);
		return ResponseEntity.ok(CourseMapper.INSTANCE.toCourseDTO(create ));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id ){
		Course course = courseService.getById(id);
		return ResponseEntity.ok(course);
	}
	@GetMapping
	public ResponseEntity<?>getCourses(@PathVariable Long br){
		
		 List<CourseDTO> collect = courseService.getCourseByCategoryId(br)
					.stream()
					.map(bro->CourseMapper.INSTANCE.toCourseDTO(bro))
					.collect(Collectors.toList());
		return ResponseEntity.ok(collect);
	}
	@PutMapping("{id}")
	public ResponseEntity<?>update(@PathVariable Long id,@RequestBody CourseDTO courseDTO){
		Course course=CourseMapper.INSTANCE.toCourse(courseDTO);
		Course update = courseService.update(course, id);
		return ResponseEntity.ok(CourseMapper.INSTANCE.toCourseDTO(update));
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?>delete(@PathVariable Long id){
		courseService.delete(id);
		return ResponseEntity.ok().build();
		
	}

}
