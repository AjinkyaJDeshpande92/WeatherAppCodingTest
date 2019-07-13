package com.ajinkyad.weatherApp.database.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by anthony on 12/27/17.
 */

/**
 * Utility class for serialization and de-serialization for storing and fetching from Room DB
 */
public class GenericTypeConverter {

    public static <T> List<T> stringToList(String json, Class<T> clazz) {
        Gson gson = new Gson();
        Type type = TypeToken.getParameterized(List.class, clazz).getType();
        List<T> items = gson.fromJson(json, type);
        return items;
    }

    public static <T> String listToString(List<T> itemResponses) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<T>>() {
        }.getType();
        String json = gson.toJson(itemResponses, type);
        return json;
    }


    public static <T> String convertJavaObjectToJson(T object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

    public static <T> T convertJsonToJavaObject(String json, Class<T> clazz) {
        Gson gson = new Gson();
        Type type = new TypeToken<T>() {
        }.getType();
        T object = gson.fromJson(json, clazz);
        return object;
    }
}
