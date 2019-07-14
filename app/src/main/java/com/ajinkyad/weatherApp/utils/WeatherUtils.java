package com.ajinkyad.weatherApp.utils;

import android.text.format.DateFormat;

import com.ajinkyad.weatherApp.repository.model.CitiesResponse;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class WeatherUtils {


    public static String getDisplayTimeFromMillis(long timestamp) {

        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timestamp);

        return DateFormat.format("EEEE hh:mm a", cal).toString();
    }

    public static String getWeatherDetails(WeatherResponse weatherResponse) {

        if (weatherResponse != null && weatherResponse.getWeather() != null && !weatherResponse.getWeather().isEmpty()) {
            //We have some valid Data
            //Lets display it to the User.
            return weatherResponse.getWeather().get(0).getMain() + " - " + weatherResponse.getWeather().get(0).getDescription();
        }
        return null;
    }

    public static ArrayList<String> getSpinnerCityDataset(List<CitiesResponse> citiesResponseList) {

        ArrayList<String> citiesList = new ArrayList<>();

        for (CitiesResponse cityItem : citiesResponseList) {
            citiesList.add(cityItem.getName());
        }
        return citiesList;
    }
}
