package com.ajinkyad.weatherApp.repository;

import com.ajinkyad.weatherApp.BuildConfig;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("/data/" + BuildConfig.API_VERSION + "/weather")
    Call<WeatherResponse> getWeatherDetails(@Query("q") String cityName, @Query("appId") String appId);
}
