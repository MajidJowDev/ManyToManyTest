package com.testprojects.manytomanysample.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)// (CascadeType.MERGE)
    @ManyToMany
    @JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    @Builder
    public Student(Long id, String firstName, String lastName, Set<Course> courses) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }


    /*  // removed because of using project Lombok
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

     */

    public Student addCourse(Course course){
        course.getStudents().add(this);
        this.courses.add(course);

        return this;
    }
}
