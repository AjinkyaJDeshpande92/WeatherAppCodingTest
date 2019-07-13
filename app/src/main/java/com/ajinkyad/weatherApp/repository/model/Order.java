package com.ajinkyad.weatherApp.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("order_id")
    @Expose
    private Integer orderId;
    @SerializedName("arrives_at_utc")
    @Expose
    private Long arrivesAtUtc;
    @SerializedName("paid_with")
    @Expose
    private String paidWith;

    public Order(Integer orderId, Long arrivesAtUtc, String paidWith) {
        this.orderId = orderId;
        this.arrivesAtUtc = arrivesAtUtc;
        this.paidWith = paidWith;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getArrivesAtUtc() {
        return arrivesAtUtc;
    }

    public void setArrivesAtUtc(Long arrivesAtUtc) {
        this.arrivesAtUtc = arrivesAtUtc;
    }

    public String getPaidWith() {
        return paidWith;
    }

    public void setPaidWith(String paidWith) {
        this.paidWith = paidWith;
    }

}