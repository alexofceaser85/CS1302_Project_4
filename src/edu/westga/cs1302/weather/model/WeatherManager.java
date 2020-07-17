package edu.westga.cs1302.weather.model;

import java.util.HashMap;
import java.util.Map;

import edu.westga.cs1302.weather.errormessages.ErrorMessages;

/**
 * The class that holds the weather for each day
 * 
 * @author Alex DeCesare
 * @version 17-July-2020
 */

public class WeatherManager {
	
	private HashMap<String, WeatherForADay> theDailyWeather;
	
	/**
	 * The constructor for the weather manager
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public WeatherManager() {
		
		this.theDailyWeather = new HashMap<String, WeatherForADay>();
		
	}
	
	/**
	 * Adds to the daily weather hashmap
	 * 
	 * @precondition weatherToAdd != null
	 * @postcondition none
	 * 
	 * @param weatherToAdd the weather for one day to add to the hashmap
	 */
	
	public void addWeatherDay(WeatherForADay weatherToAdd) {
		
		if (weatherToAdd == null) {
			throw new IllegalArgumentException(ErrorMessages.THE_WEATHER_FOR_A_DAY_CANNOT_BE_NULL);
		}
		
		this.theDailyWeather.put(weatherToAdd.getTheDate(), weatherToAdd);
		
	}
	
	/**
	 * Gets a weather date
	 * 
	 * @precondition dateToFind != null && dateToFind.isEmpty == false
	 * @postcondition none
	 * 
	 * @param dateToFind the date to find in the hash map
	 */
	
	public void getWeatherForADay(String dateToFind) {
		
		if (dateToFind == null) {
			throw new IllegalArgumentException(ErrorMessages.THE_DATE_TO_FIND_CANNOT_BE_NULL);
		}
		if (dateToFind.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.THE_DATE_TO_FIND_CANNOT_BE_EMPTY);
		}
		
		this.theDailyWeather.get(dateToFind);
	}
	
	/**
	 * The toString for the weather manager
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	@Override
	public String toString() {
		
		String description = "";
		
		for (Map.Entry<String, WeatherForADay> current : this.theDailyWeather.entrySet()) {
			
			description += current.toString();
			
		}
		
		return description;
		
	}
}
