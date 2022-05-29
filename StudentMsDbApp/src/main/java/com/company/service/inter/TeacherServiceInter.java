package com.company.service.inter;

import com.company.dao.inter.StudentRepositoryCustomInter;
import com.company.dao.inter.TeacherRepositoryCustomInter;
import com.company.entity.Student;
import com.company.entity.Teacher;

import java.util.List;

public interface TeacherServiceInter extends TeacherRepositoryCustomInter {
    Teacher getById(int id);

    Teacher getByNameAndSurname(String name, String surname);

    List<Teacher> getAllByNameAndSurname(String name, String surname);

    Teacher removeById(int id);
    Teacher findByName(String name);

}
