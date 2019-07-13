package com.ajinkyad.weatherApp.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("orders")
    @Expose
    private List<Order> orders = null;

    private String error;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}