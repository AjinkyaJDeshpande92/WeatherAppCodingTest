package com.ajinkyad.weatherApp.repository.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    @SerializedName("coord")
    @Expose
    private CoordinateDetails coordinates;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private MainDetails main;
    @SerializedName("visibility")
    @Expose
    private int visibility;
    @SerializedName("wind")
    @Expose
    private WindDetails wind;
    @SerializedName("clouds")
    @Expose
    private CloudDetails clouds;
    @SerializedName("dt")
    @Expose
    private int dt;
    @SerializedName("sys")
    @Expose
    private SystemDetails sys;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private int cod;
    @SerializedName("weather")
    @Expose
    private List<WeatherDetails> weather;

    public CoordinateDetails getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinateDetails coordinates) {
        this.coordinates = coordinates;
    }

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

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public WindDetails getWind() {
        return wind;
    }

    public void setWind(WindDetails wind) {
        this.wind = wind;
    }

    public CloudDetails getClouds() {
        return clouds;
    }

    public void setClouds(CloudDetails clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public SystemDetails getSys() {
        return sys;
    }

    public void setSys(SystemDetails sys) {
        this.sys = sys;
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

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public List<WeatherDetails> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDetails> weather) {
        this.weather = weather;
    }

    public static class CoordinateDetails {
        /**
         * lon : -0.13
         * lat : 51.51
         */

        private double lon;
        private double lat;

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
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

    public static class WindDetails {
        /**
         * speed : 4.1
         * deg : 80
         */

        private double speed;
        private int deg;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }
    }

    public static class CloudDetails {
        /**
         * all : 90
         */

        private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }
    }

    public static class SystemDetails {
        /**
         * type : 1
         * id : 5091
         * message : 0.0103
         * country : GB
         * sunrise : 1485762037
         * sunset : 1485794875
         */

        private int type;
        private int id;
        private double message;
        private String country;
        private int sunrise;
        private int sunset;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getMessage() {
            return message;
        }

        public void setMessage(double message) {
            this.message = message;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getSunrise() {
            return sunrise;
        }

        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }

        public int getSunset() {
            return sunset;
        }

        public void setSunset(int sunset) {
            this.sunset = sunset;
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
}