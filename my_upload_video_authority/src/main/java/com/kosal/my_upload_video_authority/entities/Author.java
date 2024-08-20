package com.kosal.my_upload_video_authority.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Table(name="authors")
@Entity
@Data
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="author_id")
	private Long id;
	@Column(name="author_name")
	private String name;
	@Column(name="gender")
	private Gender gender;
	@Column(name="age")
	private int age;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;

	

}
