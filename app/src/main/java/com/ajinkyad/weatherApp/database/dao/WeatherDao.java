package com.ajinkyad.weatherApp.database.dao;

import androidx.room.Dao;

import com.ajinkyad.weatherApp.database.AppDatabase;

@Dao
public abstract class WeatherDao {

    private final AppDatabase database;

    public WeatherDao(AppDatabase database) {
        this.database = database;
    }
}
