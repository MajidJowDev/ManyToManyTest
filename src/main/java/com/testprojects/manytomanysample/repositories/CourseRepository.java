package com.testprojects.manytomanysample.repositories;

import com.testprojects.manytomanysample.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {

    Optional<Course> findCourseByTitle(String title);
}
