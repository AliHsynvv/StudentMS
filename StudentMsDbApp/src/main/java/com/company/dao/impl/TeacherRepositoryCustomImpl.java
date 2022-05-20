package com.company.dao.impl;

import com.company.dao.inter.TeacherRepositoryCustomInter;
import com.company.entity.Teacher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TeacherRepositoryCustomImpl implements TeacherRepositoryCustomInter {
    @PersistenceContext
    EntityManager em;

    //    encrypt
    private static BCryptPasswordEncoder crypt = new BCryptPasswordEncoder(); //crypt password


    @Override
    public boolean addTeacher(Teacher t) {
        t.setPassword(crypt.encode(t.getPassword()));
        em.persist(t);
        return true;
    }

    @Override
    public boolean updateTeacher(Teacher t) {
        t.setPassword(crypt.encode(t.getPassword()));
        em.persist(t);
        return true;
    }
}
