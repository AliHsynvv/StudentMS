package com.company.service.inter;

import com.company.dao.inter.StudentRepositoryCustomInter;
import com.company.dao.repository.StudentRepository;
import com.company.entity.Student;

import java.util.List;

public interface StudentServiceInter extends StudentRepositoryCustomInter {
    Student getById(int id);

    List<Student> getAllByNameAndSurnameAndClazz(String name, String surname, int clazz);

    Student getByNameAndSurnameAndClazz(String name, String surname, int clazz);

    Student removeById(int id);
}
