package edu.westga.cs1302.weather.errormessages;

/**
 * Contains the error messages for the project
 * 
 * @author Alex DeCesare
 * @version 16-July-2020
 */

public class ErrorMessages {
	
	public static final String STATION_CANNOT_BE_NULL = "The weather station cannot be null";
	public static final String STATION_CANNOT_BE_EMPTY = "The weather station cannot be empty";
	public static final String LOCATION_CANNOT_BE_NULL = "The location cannot be null";
	public static final String LOCATION_CANNOT_BE_EMPTY = "The location cannot be empty";
	public static final String DATE_CANNOT_BE_NULL = "The date cannot be null";
	public static final String DATE_CANNOT_BE_EMPTY = "The date cannot be empty";
	public static final String MINIMUM_TEMPERATURE_CANNOT_BE_MORE_THAN_MAXIMUM_TEMPERATURE = "Cannot set the minimum temperature to more than the maximum temperature";
	
	public static final String THE_WEATHER_FOR_A_DAY_CANNOT_BE_NULL = "The weather for a day to add to the manager cannot be null";
	public static final String THE_DATE_TO_FIND_CANNOT_BE_NULL = "The date to find cannot be null";
	public static final String THE_DATE_TO_FIND_CANNOT_BE_EMPTY = "The date to find cannot be empty";
	
	public static final String ALERT_THERE_WAS_AN_ERROR_PARSING_THE_DATE = "There was an error with the date";
}
