package weatherapp.observers;

import weatherapp.subject.WeatherData;

public class HeatIndexDisplay implements Observer, DisplayElement {
    
    private double heatIndex;
    private WeatherData weatherData;
    
    public HeatIndexDisplay(WeatherData weatherData) {
        super();
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(){
        float myTemperature = weatherData.getTemperature();
        float myHumidity = weatherData.getHumidity();
        this.heatIndex = myTemperature + 0.55 * (1.0 - (myHumidity / 100.0)) * (myTemperature - 58.0);
        this.display();
    }
    @Override
    public void display() {
        System.out.println("Heat Index: " + heatIndex + "F Degrees");
    }
}
