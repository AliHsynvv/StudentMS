package com.company.service.impl;

import com.company.dao.inter.ScoreScienceRepositoryCustomInter;
import com.company.dao.repository.ScoreScienceRepository;
import com.company.entity.ScoreScience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScoreScienceServiceImpl implements com.company.service.inter.ScoreScienceServiceInter {
    @Autowired
    private ScoreScienceRepositoryCustomInter customInter;

    @Autowired
    private ScoreScienceRepository repository;

    @Override
    public List<ScoreScience> findScoreScienceByStudentId(int id) {
        return customInter.findScoreScienceByStudentId(id);
    }

    @Override
    public ScoreScience findScoreScienceByStudentIdAndScienceId(int science_id, int student_id) {
        return customInter.findScoreScienceByStudentIdAndScienceId(science_id, student_id);
    }

    @Override
    public boolean addScore(ScoreScience s) {
        return customInter.addScore(s);
    }

    @Override
    public boolean updateScore(ScoreScience s) {
        return customInter.updateScore(s);
    }


}
