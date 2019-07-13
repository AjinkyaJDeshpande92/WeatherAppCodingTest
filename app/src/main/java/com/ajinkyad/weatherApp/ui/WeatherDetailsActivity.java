package com.ajinkyad.weatherApp.ui;

import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.ajinkyad.weatherApp.R;
import com.ajinkyad.weatherApp.databinding.ActivityScrollingBinding;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;
import com.ajinkyad.weatherApp.viewmodel.WeatherViewModel;

import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class WeatherDetailsActivity extends AppCompatActivity {

    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    private WeatherViewModel weatherViewModel;
    private ActivityScrollingBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_scrolling);
        setSupportActionBar(dataBinding.toolbar);
        initViewModel();
        fetchCitiesList();
    }

    private void fetchCitiesList() {
        weatherViewModel.getCitiesList().observe(this, citiesResponseList -> {
            if (citiesResponseList != null && !citiesResponseList.isEmpty()) {
                //WE have some data in the Cities List
                //Get the 0th Index and render as default data to the User.
                fetchWeatherDetails(citiesResponseList.get(0).getName());
            }
        });
    }

    private void setWeatherDetails(WeatherResponse weatherResponse) {
        dataBinding.setCity(weatherResponse.getName());
        dataBinding.setTemperature(weatherResponse.getMain().getTemp() + " \u2109");
        dataBinding.setUpdatedTime(getDisplayTimeFromMillis(weatherResponse.getTime()));
        dataBinding.setWind(weatherResponse.getWindDetails().getSpeed() + " km/h");
        dataBinding.setWeather(getWeatherDetails(weatherResponse));
    }

    private String getDisplayTimeFromMillis(long timestamp) {

        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timestamp);

        return DateFormat.format("EEEE hh:mm a", cal).toString();
    }

    private String getWeatherDetails(WeatherResponse weatherResponse) {

        if (weatherResponse != null && weatherResponse.getWeather() != null && !weatherResponse.getWeather().isEmpty()) {
            //We have some valid Data
            //Lets display it to the User.
            return weatherResponse.getWeather().get(0).getMain() + " - " + weatherResponse.getWeather().get(0).getDescription();
        }

        return null;
    }

    private void fetchWeatherDetails(String cityName) {
        weatherViewModel.getWeatherDetails(cityName).observe(this, weatherResponse -> {
            if (weatherResponse != null) {
                //We have some valid data from DB
                setWeatherDetails(weatherResponse);
            }
        });
    }

    private void initViewModel() {
        AndroidInjection.inject(this);
        weatherViewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherViewModel.class);
    }
}
