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
    public Student getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Student> getAllByNameAndSurnameAndClazz(String name, String surname, int clazz) {
        return repository.getAllByNameAndSurnameAndClazz(name, surname, clazz);
    }

    @Override
    public Student getByNameAndSurnameAndClazz(String name, String surname, int clazz) {
        return repository.getByNameAndSurnameAndClazz(name,surname,clazz);
    }

    @Override
    public Student removeById(int id) {
        return repository.removeById(id);

    }
}
