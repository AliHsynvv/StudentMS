package com.company;

import com.company.dao.inter.ScoreScienceRepositoryCustomInter;
import com.company.dao.inter.TeacherRepositoryCustomInter;
import com.company.dao.repository.ScoreScienceRepository;
import com.company.entity.ScoreScience;
import com.company.entity.Student;
import com.company.entity.Teacher;
import com.company.service.inter.ScoreScienceServiceInter;
import com.company.service.inter.StudentServiceInter;
import com.company.service.inter.TeacherServiceInter;
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
    @Autowired
    private TeacherServiceInter teacherServiceInter;

    public static void main(String[] args) {
        SpringApplication.run(StudentMsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String[] args) {
                Student s = studentServiceInter.getByNameAndSurnameAndClazz("Aliakbar", "Huseynov", 11);
                List<ScoreScience> list = scoreScienceServiceInter.findScoreScienceByStudentId(s.getId());
                System.out.println(s.getName() + "\n" + "Teacher:" + s.getTeacherByTeacherId().getName());

                for (ScoreScience sc : list) {
                    System.out.println(sc.getScienceByScienceId().getName() + ":" + sc.getScore()
                    );
                }

            }
        };
        return clr;
    }
}
