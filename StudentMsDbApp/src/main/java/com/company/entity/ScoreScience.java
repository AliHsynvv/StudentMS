package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_science", schema = "studentmanagementsystem")
public class ScoreScience {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "score")
    private String score;
    @ManyToOne
    @JoinColumn(name = "science_id", referencedColumnName = "id", nullable = false)
    private Science scienceByScienceId;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student studentByStudentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreScience that = (ScoreScience) o;
        return id == that.id &&  Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score);
    }

    public Science getScienceByScienceId() {
        return scienceByScienceId;
    }

    public void setScienceByScienceId(Science scienceByScienceId) {
        this.scienceByScienceId = scienceByScienceId;
    }

    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }
}
