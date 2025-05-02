package com.example.institute;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @Query("SELECT s FROM Student s WHERE LOWER(s.course.name) LIKE LOWER(concat('%', :courseName, '%'))")
    Page<Student> findByCourseNameContainingIgnoreCase(@Param("courseName") String courseName, Pageable pageable);
}