/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.util.LinkedList;

/**
 *
 * @author yses9
 */
public class WeatherForecast {
    private LinkedList<WeatherForecast> forecast = null;
    
    String Date, City, Country, Cloudy, temp, humidity, windSpeed, windDegree, Description;

    public WeatherForecast(String Date, String temp, String Cloudy, String humidity, String windSpeed, String windDegree, String Description) {
        this.Date = Date;
        this.Cloudy = Cloudy;
        this.temp = temp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.Description = Description;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }


    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCloudy() {
        return Cloudy;
    }

    public void setCloudy(String Cloudy) {
        this.Cloudy = Cloudy;
    }

    public LinkedList<WeatherForecast> getForecast() {
        return forecast;
    }

    public void setForecast(LinkedList<WeatherForecast> forecast) {
        this.forecast = forecast;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(String windDegree) {
        this.windDegree = windDegree;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public LinkedList<WeatherForecast> getList() {
        return forecast;
    }
    
    public void setList(LinkedList<WeatherForecast> list) {
        this.forecast = list;
    }


}
