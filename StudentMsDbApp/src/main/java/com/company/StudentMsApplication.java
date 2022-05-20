package com.company;

import com.company.dao.inter.ScoreScienceRepositoryCustomInter;
import com.company.dao.repository.ScoreScienceRepository;
import com.company.entity.ScoreScience;
import com.company.entity.Student;
import com.company.service.inter.ScoreScienceServiceInter;
import com.company.service.inter.StudentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentMsApplication {
    @Autowired
    private StudentServiceInter studentServiceInter;
    @Autowired
    private ScoreScienceServiceInter scoreScienceServiceInter;


    public static void main(String[] args) {
        SpringApplication.run(StudentMsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String[] args) {
//                Student ss = studentServiceInter.getByNameAndSurnameAndClazz("Qalib", "Huseynov", 9);
//                List<ScoreScience> list = scoreScienceServiceInter.findScoreScienceByStudentId(ss.getId());
//                for (ScoreScience s : list) {
//                    System.out.println(s.getStudentByStudentId().getName() + "\n" + s.getScienceByScienceId().getName() + ":" + s.getScore());
//                }
                ScoreScience s = scoreScienceServiceInter.findScoreScienceByStudentIdAndScienceId(1, 1);
                s.setScore("12");
                scoreScienceServiceInter.updateScore(s);
            }
        };
        return clr;
    }
}
