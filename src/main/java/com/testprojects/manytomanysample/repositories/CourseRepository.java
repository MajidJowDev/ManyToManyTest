package com.testprojects.manytomanysample.repositories;

import com.testprojects.manytomanysample.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
