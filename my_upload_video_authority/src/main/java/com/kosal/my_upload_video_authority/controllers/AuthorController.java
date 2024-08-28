package com.kosal.my_upload_video_authority.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosal.my_upload_video_authority.entities.Author;
import com.kosal.my_upload_video_authority.entities.DTO.AuthorDTO;
import com.kosal.my_upload_video_authority.mapper.AuthorMapper;
import com.kosal.my_upload_video_authority.page.DTO.PageDTO;
import com.kosal.my_upload_video_authority.services.AuthorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("authors")
public class AuthorController {
	@Autowired
	private final AuthorService authorService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody AuthorDTO authorDTO) {
		Author author = AuthorMapper.INSTANCE.toAuthor(authorDTO);
		Author createdAuthor = authorService.create(author);
		return ResponseEntity.ok(AuthorMapper.INSTANCE.toAuthorDTO(createdAuthor));
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getOneAuthor(@PathVariable Long id) {
		Author author = authorService.getById(id);
		return ResponseEntity.ok(AuthorMapper.INSTANCE.toAuthorDTO(author));

	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDTO authorDTO) {
		Author author = AuthorMapper.INSTANCE.toAuthor(authorDTO);
		Author update = authorService.update(id, author);
		return ResponseEntity.ok(AuthorMapper.INSTANCE.toAuthorDTO(update));

	}

	/*
	 * @GetMapping public ResponseEntity<?> getAuthors() { List<AuthorDTO> aut =
	 * authorService.getAthor().stream().map(auth ->
	 * AuthorMapper.INSTANCE.toAuthorDTO(auth)) .collect(Collectors.toList());
	 * return ResponseEntity.ok(aut);
	 * 
	 * }
	 */

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		authorService.remove(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<?> getAuthors(@RequestParam Map<String, String> params) {
		Page<Author> authors = authorService.getAuthors(params);
		PageDTO pageDTO = new PageDTO(authors);
		return ResponseEntity.ok(pageDTO);
	}

}
