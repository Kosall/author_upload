package com.kosal.my_upload_video_authority.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.kosal.my_upload_video_authority.entities.Author;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Data
public class AuthorSpecification implements Specification<Author>{
	private final AuthorFilter authorFilter;
	List<Predicate> predicates=new ArrayList<>();

	@Override
	public Predicate toPredicate(Root<Author> author, CriteriaQuery<?> cq, CriteriaBuilder cb) {
		
		if(authorFilter.getName()!=null) {
			Predicate name = cb.like(cb.upper(author.get("name")), "%"+authorFilter.getName().toLowerCase()+"%");
			predicates.add(name);
		}
		if(authorFilter.getGender()!=null) {
			Predicate gender = author.get("gender").in(authorFilter.getGender());
			predicates.add(gender);
		}
		if(authorFilter.getAge()>0) {
			Predicate age = author.get("age").in(authorFilter.getAge());
			predicates.add(age);
		}
		if(authorFilter.getPhone()!=null) {
			Predicate phone = author.get("phone").in(authorFilter.getPhone());
			predicates.add(phone);
			
		}
		if(authorFilter.getEmail()!=null) {
			Predicate email = author.get("email").in(authorFilter.getEmail());
			predicates.add(email);
		}

		return cb.and(predicates.toArray(Predicate[]::new));
	}

}
