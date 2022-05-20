package com.company.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "countryByNationalityId")
    private Collection<Student> studentsById;
    @OneToMany(mappedBy = "countryByNationalityId")
    private Collection<Teacher> teachersById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<Student> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<Student> studentsById) {
        this.studentsById = studentsById;
    }

    public Collection<Teacher> getTeachersById() {
        return teachersById;
    }

    public void setTeachersById(Collection<Teacher> teachersById) {
        this.teachersById = teachersById;
    }
}
