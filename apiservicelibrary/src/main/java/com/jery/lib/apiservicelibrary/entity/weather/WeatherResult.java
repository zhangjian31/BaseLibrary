package com.jery.lib.apiservicelibrary.entity.weather;


import com.google.gson.annotations.SerializedName;
import com.jery.lib.networklibrary.model.BaseResult;

public class WeatherResult extends BaseResult {
    @SerializedName("result")
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {
        @SerializedName("today")
        private Today today;

        public Today getToday() {
            return today;
        }

        public void setToday(Today today) {
            this.today = today;
        }
    }

    public class Today {
        @SerializedName("temperature")
        private String temperature;
        @SerializedName("weather")
        private String weather;
        @SerializedName("wind")
        private String wind;
        @SerializedName("week")
        private String week;
        @SerializedName("dressing_advice")
        private String dressing_advice;

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

        public String getDressing_advice() {
            return dressing_advice;
        }

        public void setDressing_advice(String dressing_advice) {
            this.dressing_advice = dressing_advice;
        }
    }
}
