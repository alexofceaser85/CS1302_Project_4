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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * The class that holds the weather for each day
 * 
 * @author Alex DeCesare
 * @version 17-July-2020
 */

public class WeatherManager {
	
	private HashMap<String, WeatherForADay> theWeatherByDay;
	private ArrayList<WeatherForADay> theSortedWeather;
	
	/**
	 * The constructor for the weather manager
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public WeatherManager() {
		
		this.theWeatherByDay = new HashMap<String, WeatherForADay>();
		this.theSortedWeather = new ArrayList<WeatherForADay>();

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
		
		return this.theWeatherByDay.get(dateToFind);
	}
	
	/**
	 * Adds to the daily weather and sorts it
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
		
		this.theSortedWeather.add(weatherToAdd);
		this.sortTheArray(this.theSortedWeather);
		this.getTheWeatherSortedByDay().put(weatherToAdd.getTheDate(), weatherToAdd);
	}
	
	/**
	 * Gets the first day in the sorted array
	 * 
	 * @precondition none
	 * @postconditon none
	 * 
	 * @return the first day
	 */
	
	public WeatherForADay getTheFirstDay() {

		return this.getTheSortedWeather().get(0);
	}
	
	/**
	 * Gets the weather data
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theSortedWeather the sorted weather array
	 */
	
	public ArrayList<WeatherForADay> getTheSortedWeather() {
		return this.theSortedWeather;
	}
	
	/**
	 * Gets the weather sorted by day
	 * @return 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the weather sorted by day
	 */
	
	public HashMap<String, WeatherForADay> getTheWeatherSortedByDay() {
		return this.theWeatherByDay;
	}
	
	/**
	 * The toString for the weather manager
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	@Override
	public String toString() {
		
		String description = "The Sorted Array List: " + System.lineSeparator();
		
		for (WeatherForADay current : this.theSortedWeather) {
			description += current.toString() + System.lineSeparator();
		}
		
		description += "The Unsorted HashMap" + System.lineSeparator();
		
		for (HashMap.Entry<String, WeatherForADay> current : this.getTheWeatherSortedByDay().entrySet()) {
			description += current.toString() + System.lineSeparator();
		}
		
		return description;
		
	}
	
	private void sortTheArray(ArrayList<WeatherForADay> theSortedWeather) {
		Collections.sort(theSortedWeather, new Comparator<WeatherForADay>() {
			
			private DateFormat theDecimalFormat = new SimpleDateFormat("yyyy-MM-dd");

			@Override
			public int compare(WeatherForADay theFirstWeather, WeatherForADay theSecondWeather) {
				
				try {
					String firstDate = theFirstWeather.getTheDate();
					String secondDate = theSecondWeather.getTheDate();
					
					return this.theDecimalFormat.parse(firstDate).compareTo(this.theDecimalFormat.parse(secondDate));
				} catch (ParseException theParseException) {
					Alert theAlert = new Alert(AlertType.ERROR);
					theAlert.setContentText((ErrorMessages.ALERT_THERE_WAS_AN_ERROR_PARSING_THE_DATE));
					theAlert.showAndWait();
					return 0;
				}
			}
			
		});
	}

}
