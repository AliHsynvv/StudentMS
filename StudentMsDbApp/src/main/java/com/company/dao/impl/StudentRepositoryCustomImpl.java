package com.company.dao.impl;

import com.company.dao.inter.StudentRepositoryCustomInter;
import com.company.entity.Student;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        em.merge(s);
        return true;
    }
}
