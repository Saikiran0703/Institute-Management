package com.example.institute;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Page<Student> searchStudents(String query, String searchBy, Pageable pageable) {
        if ("name".equalsIgnoreCase(searchBy)) {
            return studentRepository.findByNameContainingIgnoreCase(query, pageable);
        } else if ("course".equalsIgnoreCase(searchBy)) {
            return studentRepository.findByCourseNameContainingIgnoreCase(query, pageable);
        }
        return studentRepository.findAll(pageable); 
    }

    public long getTotalStudents() {
        return studentRepository.count();
    }
}