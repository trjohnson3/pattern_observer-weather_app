package weatherapp;

import weatherapp.observers.CurrentConditionsDisplay;
import weatherapp.observers.HeatIndexDisplay;
import weatherapp.observers.StatisticsDisplay;
import weatherapp.subject.WeatherData;

public class app {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        
        CurrentConditionsDisplay current =
                new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay stats = new StatisticsDisplay(weatherData);
        HeatIndexDisplay heat = new HeatIndexDisplay(weatherData);
        //ForcastDisplay forcast = new ForcastDisplay(weatherData);
        
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
        
    }
    
}
