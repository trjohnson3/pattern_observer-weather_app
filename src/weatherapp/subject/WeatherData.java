package weatherapp.subject;

import java.util.ArrayList;
import java.util.List;
import weatherapp.observers.Observer;

public class WeatherData implements Subject{
    
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
        super();
        observers = new ArrayList<>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
    
    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }
    public void weatherChanged() {
        this.notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity,
            float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        weatherChanged();
    }
}
