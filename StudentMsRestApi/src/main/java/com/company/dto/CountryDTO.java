package com.company.dto;

import com.company.entity.Country;

public class CountryDTO {
    private int id;
    private String name;

    public CountryDTO(Country country) {
        this.id = country.getId();
        this.name = country.getName();
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
