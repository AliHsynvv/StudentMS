package com.company.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Science {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "scienceByScienceId")
    private Collection<ScoreScience> scoreSciencesById;
    @OneToMany(mappedBy = "scienceByScienceId")
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
        Science science = (Science) o;
        return id == science.id && Objects.equals(name, science.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<ScoreScience> getScoreSciencesById() {
        return scoreSciencesById;
    }

    public void setScoreSciencesById(Collection<ScoreScience> scoreSciencesById) {
        this.scoreSciencesById = scoreSciencesById;
    }

    public Collection<Teacher> getTeachersById() {
        return teachersById;
    }

    public void setTeachersById(Collection<Teacher> teachersById) {
        this.teachersById = teachersById;
    }
}
