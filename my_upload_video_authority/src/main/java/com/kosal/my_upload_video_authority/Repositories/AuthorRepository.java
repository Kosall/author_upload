package com.kosal.my_upload_video_authority.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kosal.my_upload_video_authority.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>,JpaSpecificationExecutor<Author>{
	List<Author>findByNameLike(String name);
	List<Author>findByNameContaining(String name);

}
