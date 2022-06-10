package com.company.dao.inter;

import com.company.entity.Student;

import java.util.List;

public interface StudentRepositoryCustomInter {
    public boolean addStudent(Student s);

    public boolean updateStudent(Student s);

    public boolean removeStudent(int id);

    public List<Student> getAll(String name, String surname);
}
