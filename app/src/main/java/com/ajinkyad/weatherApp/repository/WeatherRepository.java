package com.ajinkyad.weatherApp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ajinkyad.weatherApp.BuildConfig;
import com.ajinkyad.weatherApp.database.dao.CityDao;
import com.ajinkyad.weatherApp.repository.model.CitiesResponse;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class WeatherRepository {

    private WeatherAPI weatherAPI;
    private final CityDao cityDao;

    @Inject
    public WeatherRepository(WeatherAPI weatherAPI, CityDao cityDao) {
        this.weatherAPI = weatherAPI;
        this.cityDao = cityDao;
    }

    public LiveData<List<CitiesResponse>> getCitiesList() {
        return cityDao.getCitiesList();

    }

    public LiveData<WeatherResponse> getWeatherDetails(String cityName) {
        final MutableLiveData<WeatherResponse> data = new MutableLiveData<>();

        weatherAPI.getWeatherDetails(cityName, BuildConfig.WEATHER_API_KEY).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                if (response.isSuccessful()) {
                    response.body();
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
        return data;
    }
}
