package com.company.service.impl;

import com.company.dao.inter.StudentRepositoryCustomInter;
import com.company.dao.inter.TeacherRepositoryCustomInter;
import com.company.dao.repository.StudentRepository;
import com.company.dao.repository.TeacherRepository;
import com.company.entity.Student;
import com.company.entity.Teacher;
import com.company.service.inter.StudentServiceInter;
import com.company.service.inter.TeacherServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherServiceInter {
    @Autowired
    private TeacherRepositoryCustomInter repositoryCustomInter;
    @Autowired
    private TeacherRepository repository;


    @Override
    public boolean addTeacher(Teacher t) {
        return repositoryCustomInter.addTeacher(t);
    }

    @Override
    public boolean updateTeacher(Teacher t) {
        return repositoryCustomInter.updateTeacher(t);
    }

    @Override
    public Teacher getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Teacher getByNameAndSurname(String name, String surname) {
        return repository.getByNameAndSurname(name, surname);
    }

    @Override
    public List<Teacher> getAllByNameAndSurname(String name, String surname) {
        return repository.getAllByNameAndSurname(name, surname);
    }

    @Override
    public Teacher removeById(int id) {
        return repository.removeById(id);
    }

    @Override
    public Teacher findByName(String name) {
        return repository.findByName(name);
    }
}
