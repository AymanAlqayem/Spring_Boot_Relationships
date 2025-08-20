package com.tarifI.ManyToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_courses", // name of the join table
            joinColumns = @JoinColumn(name = "student_id"), // FK to Student
            inverseJoinColumns = @JoinColumn(name = "course_id") // FK to Course
    )
    private List<Course> courses = new ArrayList<>();
}