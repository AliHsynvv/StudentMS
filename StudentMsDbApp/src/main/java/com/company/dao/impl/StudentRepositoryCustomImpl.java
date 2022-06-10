package com.company.dao.impl;

import com.company.dao.inter.StudentRepositoryCustomInter;
import com.company.entity.Student;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentRepositoryCustomImpl implements StudentRepositoryCustomInter {
    @PersistenceContext
    EntityManager em;

    //    encrypt
    private static BCryptPasswordEncoder crypt = new BCryptPasswordEncoder(); //crypt password

    @Override
    public boolean addStudent(Student s) {
        s.setPassword(crypt.encode(s.getPassword()));
        em.persist(s);
        return true;
    }

    @Override
    public boolean updateStudent(Student s) {
        s.setPassword(crypt.encode(s.getPassword()));
        em.merge(s);
        return true;
    }

    @Override
    public boolean removeStudent(int id) {
        Student s = em.find(Student.class, id);
        em.remove(s);
        return true;
    }

    //jpql
    @Override
    public List<Student> getAll(String name, String surname) {
        String jpql = "select s from Student s where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and s.name=:name ";
        }

        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and s.surname=:surname ";
        }

        Query query = em.createQuery(jpql, Student.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }

        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }

        return query.getResultList();
    }
}
