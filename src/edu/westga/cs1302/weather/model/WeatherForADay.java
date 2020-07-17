package edu.westga.cs1302.weather.model;

import edu.westga.cs1302.weather.errormessages.ErrorMessages;

/**
 * This class holds the daily weather
 * 
 * @author Alex DeCesare
 * @version 16-July-2020
 */

public class WeatherForADay {
	
	private String theStation;
	private String theLocation;
	private String theDate;
	private double theMaximumTemperature;
	private double theMinimumTemperature;
	
	/**
	 * The constructor for the weather for a day
	 * 
	 * @precondition station != null && station.isEmpty() == false && locationName != null && locationName.isEmpty() == false && date != null && date.isEmpty() == false && minimumTemperature < maximumTemperature
	 * @postcondition station == getStation() && locationName == getLocationName() && date == getDate() && maximumTemperature == getMaximumTemperature() minimumTemperature == getMinimumTemperature()
	 * 
	 * @param station the station of the weather
	 * @param locationName the location of the weather
	 * @param date the date the weather occured
	 * @param maximumTemperature the maximum temperature of the day
	 * @param minimumTemperature the minimum temperature of the day
	 */
	
	public WeatherForADay(String station, String locationName, String date, double maximumTemperature, double minimumTemperature) {
		
		if (station == null) {
			throw new IllegalArgumentException(ErrorMessages.STATION_CANNOT_BE_NULL);
		}
		if (station.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.STATION_CANNOT_BE_EMPTY);
		}
		if (locationName == null) {
			throw new IllegalArgumentException(ErrorMessages.LOCATION_CANNOT_BE_NULL);
		}
		if (locationName.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.LOCATION_CANNOT_BE_EMPTY);
		}
		if (date == null) {
			throw new IllegalArgumentException(ErrorMessages.DATE_CANNOT_BE_NULL);
		}
		if (date.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.DATE_CANNOT_BE_EMPTY);
		}
		if (minimumTemperature > maximumTemperature) {
			throw new IllegalArgumentException(ErrorMessages.MINIMUM_TEMPERATURE_CANNOT_BE_MORE_THAN_MAXIMUM_TEMPERATURE);
		}
		
		this.theStation = station;
		this.theLocation = locationName;
		this.theDate = date;
		this.theMaximumTemperature = maximumTemperature;
		this.theMinimumTemperature = minimumTemperature;
	}
	
	/**
	 * Gets the station
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the station
	 */
	
	public String getTheStation() {
		return this.theStation;
	}
	
	/**
	 * Gets the location name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the location name
	 */
	
	public String getTheLocationName() {
		return this.theLocation;
	}
	
	/**
	 * Gets the date
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the date
	 */
	
	public String getTheDate() {
		return this.theDate;
	}
	
	/**
	 * Gets the maximum temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the maximum temperature
	 */
	
	public double getTheMaximumTemperature() {
		return this.theMaximumTemperature;
	}
	
	/**
	 * Gets the minimum temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the minimum temperature
	 */
	
	public double getTheMinimumTemperature() {
		return this.theMinimumTemperature;
	}
	
	/**
	 * The to string method for the class
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	@Override
	public String toString() { 
		return "The day: " + this.getTheDate() + " at the station: " + this.getTheStation() + " at the location: " + this.getTheLocationName() + " with the maximum temperature of: " + this.getTheMaximumTemperature() + " with the minimum temperature of: " + this.getTheMinimumTemperature();
	}

}
