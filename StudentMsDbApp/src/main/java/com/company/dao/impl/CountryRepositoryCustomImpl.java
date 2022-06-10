package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CountryRepositoryCustomImpl {
    @PersistenceContext
    EntityManager em;

    public List<Country> getAll(String name) {
        String jpql = "select c from Country c where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and c.name=:name ";
        }
        Query query = em.createQuery(jpql, Country.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }

        return query.getResultList();
    }
}
