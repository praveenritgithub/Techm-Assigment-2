package com.praveen.student_management;

import com.praveen.student_management.Student;
import com.praveen.student_management.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // List students with pagination & search
    @GetMapping({"", "/"})
    public String viewHomePage(Model model,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "keyword", required = false) String keyword) {

        Page<Student> studentPage = service.listAll(page, keyword);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "students";  // Make sure templates/students.html exists
    }

    // Show form to add student
    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "new_student"; // templates/new_student.html
    }

    // Save student
    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            return "new_student";
        }
        service.save(student);
        return "redirect:/students";
    }

    // Show form to edit
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> studentOpt = service.get(id);
        if (studentOpt.isEmpty()) {
            model.addAttribute("errorMessage", "Student not found");
            return "error";
        }
        model.addAttribute("student", studentOpt.get());
        return "edit_student"; // templates/edit_student.html
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        try {
            service.delete(id);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Could not delete student");
            return "error";
        }
        return "redirect:/students";
    }
}
