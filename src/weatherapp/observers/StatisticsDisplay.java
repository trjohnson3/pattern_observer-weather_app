package weatherapp.observers;

import weatherapp.subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement{
    
    private Float avgTemperature;
    private Float minTemperature;
    private Float maxTemperature;
    private float totalTemperature = 0;
    private int numberOfUpdates = 0;
    private WeatherData weatherData;
    
    public StatisticsDisplay(WeatherData weatherData) {
        super();
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(){
        this.numberOfUpdates++;
        float myTemperature = weatherData.getTemperature();
        calculateAvgTemperature(myTemperature);
        calculateMinTemperature(myTemperature);
        calculateMaxTemperature(myTemperature);
        this.display();
    }
    @Override
    public void display() {
        System.out.println("Avg/Min/Max temperature = " + avgTemperature
        + "/" + minTemperature + "/" + maxTemperature);
    }
    private void calculateAvgTemperature(float temperature) {
        this.totalTemperature += temperature;
        this.avgTemperature = 
                (this.totalTemperature) / this.numberOfUpdates;
    }
    private void calculateMinTemperature(float temperature) {
        if(this.minTemperature == null) {
            this.minTemperature = temperature;
        } 
        else if(temperature < this.minTemperature){
            this.minTemperature = temperature;
        }
    }
    private void calculateMaxTemperature(float temperature) {
        if(this.maxTemperature == null) {
            this.maxTemperature = temperature;
        } 
        else if(temperature > this.maxTemperature){
            this.maxTemperature = temperature;
        }
    }
    
}
