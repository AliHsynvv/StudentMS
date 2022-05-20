package com.company.dao.repository;

import com.company.entity.Student;
import com.company.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher getById(int id);

    Teacher getByNameAndSurname(String name, String surname);

    List<Teacher> getAllByNameAndSurname(String name, String surname);

    Teacher removeById(int id);
}
