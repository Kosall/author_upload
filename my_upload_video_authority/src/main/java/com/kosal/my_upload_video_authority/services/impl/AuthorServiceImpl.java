package com.kosal.my_upload_video_authority.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kosal.my_upload_video_authority.Repositories.AuthorRepository;
import com.kosal.my_upload_video_authority.entities.Author;
import com.kosal.my_upload_video_authority.entities.Gender;
import com.kosal.my_upload_video_authority.exception.ResourceNotFound;
import com.kosal.my_upload_video_authority.filter.AuthorFilter;
import com.kosal.my_upload_video_authority.filter.AuthorSpecification;
import com.kosal.my_upload_video_authority.services.AuthorService;
import com.kosal.my_upload_video_authority.utilPage.PageUtility;

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

	@Override
	public Page<Author> getAuthors(Map<String, String> params) {
		AuthorFilter authorFilter =new AuthorFilter();
		if(params.containsKey("id")) {
			String id=params.get("id");
			authorFilter.setId(Long.parseLong(id));
		}
		if(params.containsKey("name")) {
			String name=params.get("name");
			authorFilter.setName(name);
		}
		if(params.containsKey("gender")) {
			String gender=params.get("gender");
			authorFilter.setGender(Gender.valueOf(gender));
		}
		if(params.containsKey("age")) {
			String age=params.get("age");
			authorFilter.setAge(Integer.parseInt(age));
		}
		if(params.containsKey("email")) {
			String email =params.get("email");
			authorFilter.setEmail(email);
		}
		if(params.containsKey("phone")) {
			String phone=params.get("pone");
			authorFilter.setPhone(phone);
		}
		int pageLimit=PageUtility.DEFAUL_PAGE_LIMIT;
		if(params.containsKey(PageUtility.PAGE_LIMIT)) {
			pageLimit=Integer.parseInt(params.get(PageUtility.PAGE_LIMIT));
		}
		int pageNum=PageUtility.DEFAULT_PAGE_NUM;
		if(params.containsKey(PageUtility.PAGE_NUM)) {
			pageNum=Integer.parseInt(params.get(PageUtility.PAGE_NUM));
		}
		AuthorSpecification authorSpecification=new AuthorSpecification(authorFilter);
		Pageable paging=PageUtility.pageable(pageNum, pageLimit);
		Page<Author> page = authorRepository.findAll(authorSpecification, paging);
		return page;
	}

	@Override
	public List<Author> getAuthors(String name) {
		// TODO Auto-generated method stub
		return authorRepository.findByNameContaining(name);
	}

}
