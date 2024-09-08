package com.kosal.my_upload_video_authority.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="course_id")
	private Long id;
	//@Column(name="course_name")
	private String name;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	

}
