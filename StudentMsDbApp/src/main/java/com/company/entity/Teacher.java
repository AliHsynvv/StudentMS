package com.company.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Teacher {
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

    @OneToMany(mappedBy = "teacherByTeacherId")
    private Collection<Student> studentsById;
    @ManyToOne
    @JoinColumn(name = "nationality_id", referencedColumnName = "id", nullable = false)
    private Country countryByNationalityId;
    @ManyToOne
    @JoinColumn(name = "science_id", referencedColumnName = "id")
    private Science scienceByScienceId;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(name, teacher.name) && Objects.equals(surname, teacher.surname) && Objects.equals(password, teacher.password) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, password);
    }

    public Collection<Student> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<Student> studentsById) {
        this.studentsById = studentsById;
    }

    public Country getCountryByNationalityId() {
        return countryByNationalityId;
    }

    public void setCountryByNationalityId(Country countryByNationalityId) {
        this.countryByNationalityId = countryByNationalityId;
    }

    public Science getScienceByScienceId() {
        return scienceByScienceId;
    }

    public void setScienceByScienceId(Science scienceByScienceId) {
        this.scienceByScienceId = scienceByScienceId;
    }
}
