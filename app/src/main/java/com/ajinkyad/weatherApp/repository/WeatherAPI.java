package com.ajinkyad.weatherApp.repository;

import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherAPI {

    @GET("/test/orders")
    Call<WeatherResponse> getOrders();
}
