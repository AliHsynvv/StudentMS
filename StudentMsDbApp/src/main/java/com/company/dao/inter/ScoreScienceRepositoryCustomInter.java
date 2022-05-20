package com.company.dao.inter;

import com.company.entity.ScoreScience;
import com.company.service.inter.ScoreScienceServiceInter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ScoreScienceRepositoryCustomInter {
    List<ScoreScience> findScoreScienceByStudentId(int id);

    public ScoreScience findScoreScienceByStudentIdAndScienceId(int science_id, int student_id);

    public boolean addScore(ScoreScience s);

    public boolean updateScore(ScoreScience s);
}
