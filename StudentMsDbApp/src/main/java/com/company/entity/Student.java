package com.company.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "class")
    private int clazz;

    @OneToMany(mappedBy = "studentByStudentId")
    private List<ScoreScience> scoreSciencesById;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    private Teacher teacherByTeacherId;
    @ManyToOne
    @JoinColumn(name = "nationality_id", referencedColumnName = "id", nullable = false)
    private Country countryByNationalityId;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", clazz=" + clazz +
                ", scoreSciencesById=" + scoreSciencesById +
                ", teacherByTeacherId=" + teacherByTeacherId +
                ", countryByNationalityId=" + countryByNationalityId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && clazz == student.clazz &&  Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, password, clazz);
    }

    public List<ScoreScience> getScoreSciencesById() {
        return scoreSciencesById;
    }

    public void setScoreSciencesById(List<ScoreScience> scoreSciencesById) {
        this.scoreSciencesById = scoreSciencesById;
    }

    public Teacher getTeacherByTeacherId() {
        return teacherByTeacherId;
    }

    public void setTeacherByTeacherId(Teacher teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
    }

    public Country getCountryByNationalityId() {
        return countryByNationalityId;
    }

    public void setCountryByNationalityId(Country countryByNationalityId) {
        this.countryByNationalityId = countryByNationalityId;
    }
}
