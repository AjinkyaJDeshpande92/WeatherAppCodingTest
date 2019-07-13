package com.ajinkyad.weatherApp.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.ajinkyad.weatherApp.database.AppDatabase;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

@Dao
public abstract class WeatherDao {

    private final AppDatabase database;

    public WeatherDao(AppDatabase database) {
        this.database = database;
    }


    @Transaction
    @Query("SELECT * FROM WeatherResponse WHERE name =:cityName")
    public abstract LiveData<WeatherResponse> getWeatherDetails(String cityName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertWeatherDetails(WeatherResponse weatherResponse);
}
