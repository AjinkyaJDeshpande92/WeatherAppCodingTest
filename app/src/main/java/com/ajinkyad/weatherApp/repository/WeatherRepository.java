package com.ajinkyad.weatherApp.repository;

import androidx.lifecycle.LiveData;

import com.ajinkyad.weatherApp.BuildConfig;
import com.ajinkyad.weatherApp.database.dao.CityDao;
import com.ajinkyad.weatherApp.database.dao.WeatherDao;
import com.ajinkyad.weatherApp.repository.model.CitiesResponse;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

import java.util.List;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class WeatherRepository {

    private WeatherAPI weatherAPI;
    private final CityDao cityDao;
    private final WeatherDao weatherDao;

    @Inject
    public WeatherRepository(WeatherAPI weatherAPI, CityDao cityDao, WeatherDao weatherDao) {
        this.weatherAPI = weatherAPI;
        this.cityDao = cityDao;
        this.weatherDao = weatherDao;
    }

    public LiveData<List<CitiesResponse>> getCitiesList() {
        return cityDao.getCitiesList();

    }

    public LiveData<WeatherResponse> getWeatherDetails(String cityName) {
        weatherAPI.getWeatherDetails(cityName, BuildConfig.WEATHER_API_KEY).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    Executors.newSingleThreadExecutor().execute(() -> weatherDao.insertWeatherDetails(response.body()));
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
        return weatherDao.getWeatherDetails(cityName);
    }
}
