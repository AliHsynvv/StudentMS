package com.company.dao.repository;

import com.company.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getById(int id);

    Student getByNameAndSurnameAndClazz(String name, String surname, int clazz);

    List<Student> getAllByNameAndSurnameAndClazz(String name, String surname, int clazz);

    Student removeById(int id);
}
