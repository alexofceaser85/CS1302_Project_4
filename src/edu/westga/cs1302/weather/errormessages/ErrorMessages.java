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
	
	public static final String THE_LOCATION_TO_SEARCH_CANNOT_BE_NULL = "The location to find cannot be null";
	public static final String THE_LOCATION_TO_SEARCH_CANNOT_BE_EMPTY = "The location to find cannot be empty";
	
	public static final String THE_WEATHER_FOR_A_DAY_CANNOT_BE_NULL = "The weather for a day to add to the manager cannot be null";
	public static final String THE_DATE_TO_FIND_CANNOT_BE_NULL = "The date to find cannot be null";
	public static final String THE_DATE_TO_FIND_CANNOT_BE_EMPTY = "The date to find cannot be empty";
	
	public static final String CANNOT_SET_A_NULL_FILE = "Cannot set a null file name";
	public static final String CANNOT_SET_AN_EMPTY_FILE = "Cannot set an empty file";
	
	public static final String CANNOT_SAVE_A_NULL_FILE = "Cannot save a null file";
	public static final String CANNOT_SAVE_TO_A_NULL_FILE = "Cannot save to a null file";
	
	public static final String ALERT_THERE_WAS_AN_ERROR_PARSING_THE_DATE = "There was an error with the date";
	public static final String ALERT_THERE_WAS_AN_ERROR_PARSING_THE_TEMPERATURE = "There was an error with parsing the temperature";
	public static final String ALERT_THERE_WAS_AN_ERROR_READING_THE_FILE = "There was an error with reading the file";
	public static final String ALERT_CANNOT_FIND_THE_FIRST_WEATHER_DAY = "Cannot find the first weather day";
	public static final String ALERT_CANNOT_FIND_THE_MIDDLE_WEATHER_DAY = "Cannot find the middle weather day";
	public static final String ALERT_CANNOT_FIND_THE_LAST_WEATHER_DAY = "Cannot find the last weather day";
	public static final String ALERT_CANNOT_FIND_THE_DATA_OF_A_EMPTY_MANAGER = "Cannot find the data of an empty manager";
	
	public static final String NO_FILE_SELECTED_TITLE = "There is no file selected";
	public static final String NO_FILE_SELECTED_CONTENT_TEXT = "Please select a file to parse";
	public static final String ARRAY_OUT_OF_BOUNDS_FILE_SELECTED_TITLE = "There was a problem parsing this file";
	public static final String ARRAY_OUT_OF_BOUNDS_FILE_SELECTED_CONTENT_TEXT = "The format to parse this file is not valid";	
	public static final String CANNOT_SAVE_FILE_TITLE = "Cannot Save The File";
	public static final String CANNOT_SAVE_A_FILE_BEFORE_IT_IS_OPENED_CONTENT_TEXT = "Cannot save a file that was never opened, please open a file first";
}
