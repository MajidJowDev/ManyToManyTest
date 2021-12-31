package com.testprojects.manytomanysample.bootstrap;

import com.testprojects.manytomanysample.model.Course;
import com.testprojects.manytomanysample.model.Student;
import com.testprojects.manytomanysample.repositories.CourseRepository;
import com.testprojects.manytomanysample.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public DataLoader(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    //@Transactional
    public void run(String... args) throws Exception {

        simpleDataInitiation();

    }

    private void simpleDataInitiation(){


        /**Basic Object Generation**/
        Course programming = new Course();
        programming.setTitle("Programming");
        programming.setDescription("Programming with an Object Oriented Language");
        Course savedProgramming = courseRepository.save(programming);

        Course uiDesign = new Course();
        uiDesign.setTitle("UI Design");
        uiDesign.setDescription("Learning Front End Techs and UI Design");
        Course savedUIDesign = courseRepository.save(uiDesign);



        Student student_A = new Student();
        student_A.setFirstName("Majid");
        student_A.setLastName("Xoqi");
        student_A.addCourse(savedProgramming);
        student_A.addCourse(savedUIDesign);

        studentRepository.save(student_A);
    }

}
