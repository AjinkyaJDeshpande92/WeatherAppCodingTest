package com.ajinkyad.weatherApp.repository.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.ajinkyad.weatherApp.database.converters.WeatherDataConverters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
@TypeConverters({WeatherDataConverters.class})
public class WeatherResponse {

    /**
     * coord : {"lon":-0.13,"lat":51.51}
     * weather : [{"id":300,"main":"Drizzle","description":"light intensity drizzle","icon":"09d"}]
     * base : stations
     * main : {"temp":280.32,"pressure":1012,"humidity":81,"temp_min":279.15,"temp_max":281.15}
     * visibility : 10000
     * wind : {"speed":4.1,"deg":80}
     * clouds : {"all":90}
     * dt : 1485789600
     * sys : {"type":1,"id":5091,"message":0.0103,"country":"GB","sunrise":1485762037,"sunset":1485794875}
     * id : 2643743
     * name : London
     * cod : 200
     */

    @PrimaryKey(autoGenerate = true)
    private int cityId;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private MainDetails main;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("weather")
    @Expose
    private List<WeatherDetails> weather;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainDetails getMain() {
        return main;
    }

    public void setMain(MainDetails main) {
        this.main = main;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeatherDetails> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDetails> weather) {
        this.weather = weather;
    }

    public static class MainDetails {
        /**
         * temp : 280.32
         * pressure : 1012
         * humidity : 81
         * temp_min : 279.15
         * temp_max : 281.15
         */

        private double temp;
        private int pressure;
        private int humidity;
        private double temp_min;
        private double temp_max;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }
    }

    public static class WeatherDetails {
        /**
         * id : 300
         * main : Drizzle
         * description : light intensity drizzle
         * icon : 09d
         */

        private int id;
        private String main;
        private String description;
        private String icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}