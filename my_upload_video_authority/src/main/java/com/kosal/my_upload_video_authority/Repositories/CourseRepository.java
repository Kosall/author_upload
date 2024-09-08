package com.kosal.my_upload_video_authority.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosal.my_upload_video_authority.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
