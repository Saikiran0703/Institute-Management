package com.example.institute;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    private String duration;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

   
    public Course() {
    }

    public Course(String name, String description, String duration, Instructor instructor) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.instructor = instructor;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +"id=" + id +", name='" + name + '\'' + ", description='" + description + '\'' +", duration='" + duration + '\'' +", instructor=" + (instructor != null ? instructor.getName() : null) +'}';
    }
}