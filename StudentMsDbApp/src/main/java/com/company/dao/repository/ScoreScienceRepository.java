package com.company.dao.repository;

import com.company.entity.ScoreScience;
import com.company.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreScienceRepository extends JpaRepository<ScoreScience, Long> {
}
