package com.ajinkyad.weatherApp.database.converters;

import androidx.room.TypeConverter;

import com.ajinkyad.weatherApp.repository.model.WeatherResponse;

import java.util.List;

public class WeatherDataConverters {

    @TypeConverter
    public static List<WeatherResponse.WeatherDetails> stringToWeatherDetails(String json) {
        return GenericTypeConverter.stringToList(json, WeatherResponse.WeatherDetails.class);
    }

    @TypeConverter
    public static String weatherDetailsToString(List<WeatherResponse.WeatherDetails> weatherDetailsList) {
        return GenericTypeConverter.listToString(weatherDetailsList);
    }


    @TypeConverter
    public static WeatherResponse.MainDetails stringtoMainDetails(String response) {
        return GenericTypeConverter.convertJsonToJavaObject(response, WeatherResponse.MainDetails.class);
    }

    @TypeConverter
    public static String mainDetailsToString(WeatherResponse.MainDetails contentResponses) {
        return GenericTypeConverter.convertJavaObjectToJson(contentResponses);
    }

    @TypeConverter
    public static WeatherResponse.WindDetails stringtoWindDetails(String response) {
        return GenericTypeConverter.convertJsonToJavaObject(response, WeatherResponse.WindDetails.class);
    }

    @TypeConverter
    public static String windDetailsToString(WeatherResponse.WindDetails contentResponses) {
        return GenericTypeConverter.convertJavaObjectToJson(contentResponses);
    }

}
