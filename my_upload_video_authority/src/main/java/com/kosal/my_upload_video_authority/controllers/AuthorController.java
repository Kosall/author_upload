package com.kosal.my_upload_video_authority.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kosal.my_upload_video_authority.entities.Author;
import com.kosal.my_upload_video_authority.entities.DTO.AuthorDTO;
import com.kosal.my_upload_video_authority.mapper.AuthorMapper;
import com.kosal.my_upload_video_authority.services.AuthorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("authors")
public class AuthorController {
	@Autowired
	private final AuthorService authorService;
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody AuthorDTO authorDTO){
		Author author=AuthorMapper.INSTANCE.toAuthor(authorDTO);
		Author createdAuthor = authorService.create(author);
		return ResponseEntity.ok(AuthorMapper.INSTANCE.toAuthorDTO(createdAuthor));
	}

}
