package com.ajinkyad.weatherApp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class WeatherRepository {

    private WeatherAPI weatherAPI;

    @Inject
    public WeatherRepository(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    public LiveData<WeatherResponse> getOrders() {
        final MutableLiveData<WeatherResponse> data = new MutableLiveData<>();

        weatherAPI.getOrders().enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
//                if (response.code() == 200) {
//                    data.setValue(response.body());
//                } else if (response.code() == 503) {
//                    DahmakanResponse d = new DahmakanResponse();
//                    d.setError("Service unavilable, please try later");
//                    data.setValue(d);
//                } else {
//                    DahmakanResponse d = new DahmakanResponse();
//                    d.setError("Some error occurred, please try later");
//                    data.setValue(d);
//                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
//                DahmakanResponse d = new DahmakanResponse();
//                d.setError("Some error occurred, please try later");
//                data.setValue(d);
            }
        });
        return data;
    }
}
