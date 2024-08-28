package com.kosal.my_upload_video_authority.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.kosal.my_upload_video_authority.entities.Author;

public interface AuthorService {
	Author create(Author author);
	Author getById(Long id);
	Author update(Long id,Author authorUpdate);
	List<Author> getAthor();
	List<Author>getAuthors(String name);
	void remove(Long id);
	Page<Author>getAuthors(Map<String, String>params);

}
