package com.ajinkyad.weatherApp.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.ajinkyad.weatherApp.database.AppDatabase;
import com.ajinkyad.weatherApp.repository.model.CitiesResponse;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class CityDao {

    private final AppDatabase database;

    public CityDao(AppDatabase database) {
        this.database = database;
    }

    @Transaction
    @Query("SELECT * FROM CitiesResponse")
    public abstract LiveData<List<CitiesResponse>> getCitiesList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAllCities(List<CitiesResponse> citiesList);

    public static List<CitiesResponse> populateDefaultCities() {

        ArrayList<CitiesResponse> defaultCities = new ArrayList<>();
        defaultCities.add(new CitiesResponse("Sydney"));
        defaultCities.add(new CitiesResponse("Melbourne"));
        defaultCities.add(new CitiesResponse("Wollongong"));

        return defaultCities;
    }
}
