package weatherapp.observers;

import weatherapp.subject.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    
    private float temperature;
    private float humidity;
    private WeatherData weatherData;
    
    public CurrentConditionsDisplay(WeatherData weatherData) {
        super();
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(){
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.display();
    }
    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature 
        + "F degrees and " + humidity + "% humidity");
    }
}
