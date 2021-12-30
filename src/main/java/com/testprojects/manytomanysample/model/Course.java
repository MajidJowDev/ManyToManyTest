package com.testprojects.manytomanysample.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Lob
    private String description;

    @ManyToMany(mappedBy = "courses") // mapped by the set name in other side of relation
    private Set<Student> students = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
