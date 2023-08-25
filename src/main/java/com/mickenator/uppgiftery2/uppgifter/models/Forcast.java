package com.mickenator.uppgiftery2.uppgifter.models;

import java.util.Date;
import java.util.UUID;

public class Forcast {
    // obj ID
    private UUID id;
    private int date;  // för inlämning date, inte int
    private int hour;
    private float temperature;

    // constructor??
    public String SortOrder() {return String.valueOf(date) + hour;}

    public Forcast() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}


