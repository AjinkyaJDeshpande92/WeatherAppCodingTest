package com.ajinkyad.weatherApp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ajinkyad.weatherApp.repository.WeatherRepository;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

import javax.inject.Inject;

public class WeatherViewModel extends ViewModel {

    private LiveData<WeatherResponse> weatherResponseLiveData;

    private WeatherRepository weatherRepository;

    @Inject
    WeatherViewModel(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public void getOrders() {
        weatherResponseLiveData = weatherRepository.getOrders();
    }

    public LiveData<WeatherResponse> getWeatherResponseLiveData() {
        return weatherResponseLiveData;
    }
}
