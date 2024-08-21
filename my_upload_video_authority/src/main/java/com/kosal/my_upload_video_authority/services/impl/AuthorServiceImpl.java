package com.kosal.my_upload_video_authority.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosal.my_upload_video_authority.Repositories.AuthorRepository;
import com.kosal.my_upload_video_authority.entities.Author;
import com.kosal.my_upload_video_authority.services.AuthorService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	private final AuthorRepository authorRepository;

	@Override
	public Author create(Author author) {
		// TODO Auto-generated method stub
		return authorRepository.save(author);
	}

}
