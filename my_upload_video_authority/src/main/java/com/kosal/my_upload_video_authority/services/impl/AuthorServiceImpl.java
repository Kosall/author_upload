package com.kosal.my_upload_video_authority.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosal.my_upload_video_authority.Repositories.AuthorRepository;
import com.kosal.my_upload_video_authority.entities.Author;
import com.kosal.my_upload_video_authority.exception.ResourceNotFound;
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

	@Override
	public Author getById(Long id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id)
				.orElseThrow(()->new ResourceNotFound("Author", id));
	}

	@Override
	public Author update(Long id, Author authorUpdate) {
		// TODO Auto-generated method stub
		Author author = getById(id);
		author.setName(authorUpdate.getName());
		author.setGender(authorUpdate.getGender());
		author.setAge(authorUpdate.getAge());
		author.setEmail(authorUpdate.getEmail());
		author.setPhone(authorUpdate.getPhone());
		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAthor() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		Author author = getById(id);
		// TODO Auto-generated method stub
		authorRepository.delete(author);
		
	}

}
