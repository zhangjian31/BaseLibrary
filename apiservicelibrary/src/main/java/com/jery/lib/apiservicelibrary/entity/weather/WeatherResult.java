package com.jery.lib.apiservicelibrary.entity.weather;


import com.google.gson.annotations.SerializedName;
import com.jery.lib.networklibrary.model.BaseResult;

import java.io.Serializable;

public class WeatherResult extends BaseResult {
    @SerializedName("result")
    private WeatherInfo result;

    public WeatherInfo getResult() {
        return result;
    }

    public void setResult(WeatherInfo result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WeatherResult{" +
                "result=" + result +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static class WeatherInfo implements Serializable {
        @SerializedName("temperature")
        private String temperature;
        @SerializedName("weather")
        private String weather;
        @SerializedName("wind")
        private String wind;
        @SerializedName("week")
        private String week;
        @SerializedName("city")
        private String city;
        @SerializedName("date_y")
        private String date_y;

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDate_y() {
            return date_y;
        }

        public void setDate_y(String date_y) {
            this.date_y = date_y;
        }

        @Override
        public String toString() {
            return "WeatherInfo{" +
                    "temperature='" + temperature + '\'' +
                    ", weather='" + weather + '\'' +
                    ", wind='" + wind + '\'' +
                    ", week='" + week + '\'' +
                    ", city='" + city + '\'' +
                    ", date_y='" + date_y + '\'' +
                    '}';
        }
    }


}
