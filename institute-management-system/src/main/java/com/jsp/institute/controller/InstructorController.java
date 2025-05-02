package com.example.institute;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public String listInstructors(Model model) {
        model.addAttribute("instructors", instructorService.getAllInstructors());
        return "instructors/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructors/form";
    }

    @PostMapping("/save")
    public String saveInstructor(@Valid @ModelAttribute("instructor") Instructor instructor, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "instructors/form";
        }
        instructorService.saveInstructor(instructor);
        redirectAttributes.addFlashAttribute("successMessage", "Instructor saved successfully");
        return "redirect:/instructors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Instructor> instructor = instructorService.getInstructorById(id);
        if (instructor.isPresent()) {
            model.addAttribute("instructor", instructor.get());
            return "instructors/form";
        } else {
            return "redirect:/instructors";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        instructorService.deleteInstructor(id);
        redirectAttributes.addFlashAttribute("successMessage", "Instructor deleted successfully");
        return "redirect:/instructors";
    }
}