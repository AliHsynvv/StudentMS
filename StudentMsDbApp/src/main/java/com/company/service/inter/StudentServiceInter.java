package com.company.service.inter;

import com.company.dao.inter.StudentRepositoryCustomInter;
import com.company.dao.repository.StudentRepository;
import com.company.entity.Student;

import java.util.List;

public interface StudentServiceInter extends StudentRepositoryCustomInter {
    Student getById(int id);

    Student findByName(String name);

    List<Student> findByNameAndSurname(String name, String surname);

    Student removeById(int id);
}
