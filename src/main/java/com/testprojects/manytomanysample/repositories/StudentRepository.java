package com.testprojects.manytomanysample.repositories;

import com.testprojects.manytomanysample.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
