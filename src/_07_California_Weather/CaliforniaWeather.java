package _07_California_Weather;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 °F
 * 		
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature °F = 65.0, max temperature °F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather {
	
    void start() {
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
        
        String cityInput = JOptionPane.showInputDialog("What city do you want to find the weather for?");
        cityInput = Utilities.capitalizeWords(cityInput);
        WeatherData cityOne = weatherData.get(cityInput);
        System.out.println(cityOne);
        
        if( cityOne == null ) {
            System.out.println("Unable to find weather data for: " + cityOne);
        } else {
            System.out.println(cityInput + " is " + cityOne.weatherSummary + " with a temperature of " + cityOne.temperatureF + " F");
        }
        
        String weatherConditionsInput = JOptionPane.showInputDialog("What weather conditions are you looking for?");
        weatherConditionsInput = Utilities.capitalizeWords(weatherConditionsInput);
        
        HashMap<String, WeatherData> city = Utilities.getWeatherData();
        ArrayList<String> citiesF = new ArrayList<String>();
        
        for (String cityName : city.keySet()) {
        	WeatherData cityI = weatherData.get(cityName);
        		if(cityI.weatherSummary.equals(weatherConditionsInput)) {
        			citiesF.add(cityName);
        	}
        }
        System.out.println("Cities that are "+weatherConditionsInput+" include"+citiesF);
    }
}
