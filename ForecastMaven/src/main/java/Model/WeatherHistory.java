/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ASUS
 */
public class WeatherHistory {

    public WeatherHistory(String Celcius, String City, String Country, String Cloudy, String Humidity, String WindDegree, String WindSpeed, String Description) {
        this.Celcius = Celcius;
        this.City = City;
        this.Country = Country;
        this.Cloudy = Cloudy;
        this.Humidity = Humidity;
        this.WindDegree = WindDegree;
        this.WindSpeed = WindSpeed;
        this.Description = Description;
    }
    public String getCelcius() {
        return Celcius;
    }

    public void setCelcius(String Celcius) {
        this.Celcius = Celcius;
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

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String Humidity) {
        this.Humidity = Humidity;
    }

    public String getWindDegree() {
        return WindDegree;
    }

    public void setWindDegree(String WindDegree) {
        this.WindDegree = WindDegree;
    }

    public String getWindSpeed() {
        return WindSpeed;
    }

    public void setWindSpeed(String WindSpeed) {
        this.WindSpeed = WindSpeed;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    String Celcius;
    String City;
    String Country;
    String Cloudy;
    String Humidity;
    String WindDegree;
    String WindSpeed;
    String Description;


}
