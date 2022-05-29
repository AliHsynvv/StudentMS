package com.company.dao.impl;

import com.company.dao.inter.ScoreScienceRepositoryCustomInter;
import com.company.entity.ScoreScience;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ScoreScienceRepositoryCustomImpl implements ScoreScienceRepositoryCustomInter {
    @PersistenceContext
    EntityManager em;
    //Native Query

    @Override
    public List<ScoreScience> findScoreScienceByStudentId(int student_id) {
        Query query = em.createNativeQuery("select * from score_science where student_id=?", ScoreScience.class);
        query.setParameter(1, student_id);
        List<ScoreScience> list = query.getResultList();
        return list;
    }

    //Native Query
    @Override
    public ScoreScience findScoreScienceByStudentIdAndScienceId(int science_id, int student_id) {
        Query query = em.createNativeQuery("select * from score_science where science_id=? and student_id=?", ScoreScience.class);
        query.setParameter(1, science_id);
        query.setParameter(2, student_id);

        List<ScoreScience> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean addScore(ScoreScience s) {
        em.persist(s);
        return true;
    }

    @Override
    public boolean updateScore(ScoreScience s) {
        em.merge(s);
        return true;
    }
}
