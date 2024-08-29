package com.kosal.my_upload_video_authority.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private Long id;
	@Column(name="course_name")
	private String name;
	@OneToMany
	@JoinColumn(name="video_id")
	private Video video;

}
