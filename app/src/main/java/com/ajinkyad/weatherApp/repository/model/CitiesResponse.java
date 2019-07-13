package com.ajinkyad.weatherApp.repository.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CitiesResponse {
    public CitiesResponse() {

    }

    public CitiesResponse(String cityName) {
        name = cityName;
    }

    /**
     * name : Sydney
     */
    @PrimaryKey
    @NonNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
