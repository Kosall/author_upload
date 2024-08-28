package com.kosal.my_upload_video_authority.entities.DTO;

import com.kosal.my_upload_video_authority.entities.Gender;

import lombok.Data;

@Data
public class AuthorDTO {
	//private Long id;
	private String name;
	private Gender gender;
	private int age;
	private String phone;
	private String email;

}
