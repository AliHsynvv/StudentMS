package com.company.service.impl;

import com.company.dao.inter.StudentRepositoryCustomInter;
import com.company.dao.repository.StudentRepository;
import com.company.entity.Student;
import com.company.service.inter.StudentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentServiceInter {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentRepositoryCustomInter service;

    @Override
    public boolean addStudent(Student s) {
        return service.addStudent(s);
    }

    @Override
    public boolean updateStudent(Student s) {
        return service.updateStudent(s);
    }

    @Override
    public List<Student> getAll(String name, String surname) {
        return service.getAll(name, surname);
    }

    @Override
    public Student getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Student findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Student> findByNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

    @Override
    public Student removeById(int id) {
        return repository.removeById(id);

    }

}
