package com.ajinkyad.weatherApp.database;

import androidx.annotation.VisibleForTesting;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ajinkyad.weatherApp.BuildConfig;
import com.ajinkyad.weatherApp.database.dao.CityDao;
import com.ajinkyad.weatherApp.database.dao.WeatherDao;
import com.ajinkyad.weatherApp.repository.model.CitiesResponse;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

@Database(entities = {WeatherResponse.class, CitiesResponse.class}, version = BuildConfig.ROOM_DB_VERSION)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WeatherDao weatherDao();

    public abstract CityDao cityDao();

    @VisibleForTesting
    public static final String DATABASE_NAME = "WeatherAppDB";
}
