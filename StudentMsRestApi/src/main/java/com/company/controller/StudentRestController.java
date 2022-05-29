package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.StudentDTO;
import com.company.entity.Student;
import com.company.service.inter.StudentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentRestController {
    @Autowired
    private StudentServiceInter studentServiceInter;

    @GetMapping("/students")
    public ResponseEntity<ResponseDTO> getStudents(@RequestParam(name = "name", required = false) String name,
                                                   @RequestParam(name = "surname", required = false) String surname) {
        List<Student> students = studentServiceInter.getAll(name, surname);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            studentDTOS.add(new StudentDTO(s));
        }
        return ResponseEntity.ok(ResponseDTO.of(studentDTOS));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ResponseDTO> getUsers(@PathVariable("id") int id) {
        Student students = studentServiceInter.getById(id);
        return ResponseEntity.ok(ResponseDTO.of(new StudentDTO(students)));
    }
}
