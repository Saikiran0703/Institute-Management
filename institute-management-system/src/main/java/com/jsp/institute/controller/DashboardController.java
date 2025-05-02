package com.jsp.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.institute.service.CourseService;
import com.jsp.institute.service.InstructorService;
import com.jsp.institute.service.StudentService;

@Controller
public class DashboardController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/")
    public String showDashboard(Model model) {
        int studentCount = studentService.getAllStudents().size();
        int courseCount = courseService.getAllCourses().size();
        int instructorCount = instructorService.getAllInstructors().size();

        model.addAttribute("studentCount", studentCount);
        model.addAttribute("courseCount", courseCount);
        model.addAttribute("instructorCount", instructorCount);

        return "dashboard";
    }
}