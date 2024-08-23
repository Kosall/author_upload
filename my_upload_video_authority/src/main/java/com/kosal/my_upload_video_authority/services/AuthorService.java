package com.kosal.my_upload_video_authority.services;

import java.util.List;

import com.kosal.my_upload_video_authority.entities.Author;

public interface AuthorService {
	Author create(Author author);
	Author getById(Long id);
	Author update(Long id,Author authorUpdate);
	List<Author> getAthor();
	void remove(Long id);

}
