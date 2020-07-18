package edu.westga.cs1302.weather.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
	 * 
	 * @return The weather for a given day 
	 */
	
	public WeatherForADay getWeatherForADay(String dateToFind) {
		
		if (dateToFind == null) {
			throw new IllegalArgumentException(ErrorMessages.THE_DATE_TO_FIND_CANNOT_BE_NULL);
		}
		if (dateToFind.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.THE_DATE_TO_FIND_CANNOT_BE_EMPTY);
		}
		
		return this.theDailyWeather.get(dateToFind);
	}
	
	/**
	 */
	
	public void getTheSortedWeather() {
		
		ArrayList<WeatherForADay> theSortedWeather = new ArrayList<WeatherForADay>();
		
		for (Map.Entry<String, WeatherForADay> current : this.theDailyWeather.entrySet()) {
			theSortedWeather.add(current.getValue());
		}
		
		Collections.sort(theSortedWeather, new Comparator<WeatherForADay>() {
			
			private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			@Override
			public int compare(WeatherForADay o1, WeatherForADay o2) {
				
				String firstDate = o1.getTheDate();
				String secondDate = o2.getTheDate();
				
				try {
					return this.df.parse(firstDate).compareTo(this.df.parse(secondDate));
				} catch (ParseException theParseException) {
					System.out.println("I cannot");
					return 0;
				}
			}
			
		});
		System.out.println(theSortedWeather);
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
			
			description += current.getValue().toString() + System.lineSeparator();
			
		}
		
		return description;
		
	}

}
