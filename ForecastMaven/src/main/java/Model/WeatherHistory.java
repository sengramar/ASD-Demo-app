/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jiwonyou
 */
public class WeatherHistory
{
    private String date, time, locationID, temperature, humidity, windspeed, winddirection, cloudy, description;

 

    public WeatherHistory(String date, String time, String locationID, String temperature, String humidity, String windspeed, String winddirection, String cloudy, String description) 
    {
        this.date = date;
        this.time = time;
        this.locationID = locationID;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windspeed = windspeed;
        this.winddirection = winddirection;
        this.cloudy = cloudy;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection;
    }

    public String getCloudy() {
        return cloudy;
    }

    public void setCloudy(String cloudy) {
        this.cloudy = cloudy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 
    
}
