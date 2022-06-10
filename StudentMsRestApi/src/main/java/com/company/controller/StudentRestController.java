package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.StudentDTO;
import com.company.entity.Student;
import com.company.service.inter.StudentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        List<Student> students = studentServiceInter.findByNameAndSurname(name, surname);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            studentDTOS.add(new StudentDTO(s));
        }
        return ResponseEntity.ok(ResponseDTO.of(studentDTOS));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ResponseDTO> getStudents(@PathVariable("id") int id) {
        Student students = studentServiceInter.getById(id);
        return ResponseEntity.ok(ResponseDTO.of(new StudentDTO(students)));
    }

    @DeleteMapping("/students/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteStudents(@PathVariable("id") int id) {
        Student students = studentServiceInter.getById(id);
        studentServiceInter.removeStudent(students.getId());
        return ResponseEntity.ok(ResponseDTO.of(new StudentDTO(students), "Succesfully deleted"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addStudents(@RequestBody StudentDTO studentDTO) {
        Student s = new Student();
        s.setName(studentDTO.getName());
        s.setSurname(studentDTO.getSurname());
        s.setPassword(studentDTO.getPassword());
        studentServiceInter.addStudent(s);
        StudentDTO s1 = new StudentDTO();
        s1.setName(s.getName());
        s1.setSurname(s.getSurname());
        s1.setPassword(s.getPassword());


        return ResponseEntity.ok(ResponseDTO.of(s1, "Successfully added"));
    }
}
