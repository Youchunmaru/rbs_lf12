package de.rbsulm.rbs_lf12.model;

import java.math.BigDecimal;

public class WeatherData {

    private final Data current;
    private final Data tomorrow;
    private final Data dayAfterTomorrow;
    private final String location;

    public WeatherData(){
        final BigDecimal defaultValue = BigDecimal.valueOf(-1);
        final Data defaultData = new Data(defaultValue, defaultValue, defaultValue);
        current = defaultData;
        tomorrow = defaultData;
        dayAfterTomorrow = defaultData;
        location = "N/A";
    }
    public WeatherData(String location, Data current, Data tomorrow, Data dayAfterTomorrow) {
        this.current = current;
        this.tomorrow = tomorrow;
        this.dayAfterTomorrow = dayAfterTomorrow;
        this.location = location;
    }

    public Data current(){
        return current;
    }
    public Data tomorrow(){
        return tomorrow;
    }
    public Data dayAfterTomorrow(){
        return dayAfterTomorrow;
    }

    public String location(){ return location; }

    public record Data(BigDecimal tempC, BigDecimal precipMm, BigDecimal windKph){

    }
}
