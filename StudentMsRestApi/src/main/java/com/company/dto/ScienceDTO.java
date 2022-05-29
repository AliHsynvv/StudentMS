package com.company.dto;

import com.company.entity.Science;

public class ScienceDTO {
    private int id;
    private String name;

    public ScienceDTO(Science science) {
        this.id = science.getId();
        this.name = science.getName();
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
}
