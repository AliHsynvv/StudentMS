package com.company.controller;

import com.company.dao.impl.CountryRepositoryCustomImpl;
import com.company.entity.Country;
import com.company.entity.Student;
import com.company.service.inter.StudentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceInter service;
    String name = null;
    String surname = null;

    @GetMapping("/students")
    public String showStudentList(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "surname", required = false) String surname,
                                  Model model) {
        List<com.company.entity.Student> listStudents = service.getAll(name, surname);
        model.addAttribute("listStudents", listStudents);
        model.addAttribute("pageTitle", "Add new Student");
        return "students";
    }

    @GetMapping("/students/new")
    public String showNewForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Add new Student");
        return "student_form";
    }

    @PostMapping("/students/save")
    public String saveStudent(Student student, RedirectAttributes ra) {
        service.addStudent(student);
        ra.addFlashAttribute("message", "The student has been saved succesfully");
        return "redirect:/students";
    }


    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable("id") int id, RedirectAttributes ra, Model model) {
        try {
            Student s = service.getById(id);
            model.addAttribute("student", s);
            return "student_form";
        } catch (UsernameNotFoundException e) {
            ra.addFlashAttribute("message", "The student has been saved succesfully");
            return "redirect:/students";
        }

    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, RedirectAttributes ra, Model model) {
        try {
            Student s = service.getById(id);
            service.removeStudent(id);
            ra.addFlashAttribute("message", "The Student:" + s.getName() + " " + s.getSurname() + " has been deleted");
        } catch (UsernameNotFoundException e) {
            ra.addFlashAttribute("message", "The student has been saved succesfully");
        }
        return "redirect:/students";

    }

}
