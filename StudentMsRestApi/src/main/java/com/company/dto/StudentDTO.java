package com.company.dto;

import com.company.entity.ScoreScience;
import com.company.entity.Student;
import com.company.service.inter.ScoreScienceServiceInter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO {
    private int id;
    private String name;
    private String surname;
    private String password;
    private CountryDTO country;
    private List<ScoreScienceDTO> scienceDTO;

    public StudentDTO() {
    }

    public StudentDTO(Student s) {
        this.id = s.getId();
        this.name = s.getName();
        this.surname = s.getSurname();
        this.password = s.getPassword();
        this.country = new CountryDTO(s.getCountryByNationalityId());

        List<ScoreScienceDTO> list = new ArrayList<>();
        List<ScoreScience> scoreScienceList = s.getScoreSciencesById();
        for (int i = 0; i < scoreScienceList.size(); i++) {
            ScoreScience scoreScience = scoreScienceList.get(i);
            list.add(new ScoreScienceDTO(scoreScience));
        }
        scienceDTO = list;

//        List<UserSkillDTO> list = new ArrayList<>();
//        List<UserSkill> userSkills = u.getSkills();
//        for (int i = 0; i < userSkills.size(); i++) {
//            UserSkill uSkill = userSkills.get(i);
//            list.add(new UserSkillDTO(uSkill));
//        }
//        skills = list;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public List<ScoreScienceDTO> getScienceDTO() {
        return scienceDTO;
    }

    public void setScienceDTO(List<ScoreScienceDTO> scienceDTO) {
        this.scienceDTO = scienceDTO;
    }
}
