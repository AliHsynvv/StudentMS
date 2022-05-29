package com.company.dto;

import com.company.entity.ScoreScience;

public class ScoreScienceDTO {
    private int id;
    private String score;
    private ScienceDTO scienceDTO;

    public ScoreScienceDTO(ScoreScience science) {
        this.id = science.getId();
        this.score = science.getScore();
        this.scienceDTO = new ScienceDTO(science.getScienceByScienceId());
    }

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

    public ScienceDTO getScienceDTO() {
        return scienceDTO;
    }

    public void setScienceDTO(ScienceDTO scienceDTO) {
        this.scienceDTO = scienceDTO;
    }
}
