package com.company;

import com.company.dao.impl.CountryRepositoryCustomImpl;
import com.company.dao.repository.StudentRepository;
import com.company.entity.Country;
import com.company.entity.Student;
import com.company.service.inter.ScoreScienceServiceInter;
import com.company.service.inter.StudentServiceInter;
import com.company.service.inter.TeacherServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
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
    private StudentRepository repository;
    @Autowired
    private TeacherServiceInter teacherServiceInter;
    @Autowired
    private CountryRepositoryCustomImpl countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentMsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String[] args) {

            }
        };
        return clr;
    }
}
