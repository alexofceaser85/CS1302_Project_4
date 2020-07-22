package edu.westga.cs1302.weather.chart;

import edu.westga.cs1302.weather.model.WeatherManager;

/**
 * The class that defines all of the math for the chart
 * 
 * @author Alex DeCesare
 * @version 20-July-2020
 */

public class ChartData {

	private WeatherManager theWeatherData;
	
	/**
	 * The constructor for the chart math
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param weatherData the data for the weather
	 */
	
	public ChartData(WeatherManager weatherData) {
		
		this.theWeatherData = weatherData;
		
	}
	
	/**
	 * Gets the weather data
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the weather data
	 */
	
	public WeatherManager getTheWeatherData() {
		return this.theWeatherData;
	}
	
	/**
	 * Gets the lowest temperature in the file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theLowestTemperature the lowest temperature in the file
	 */
	
	public double getTheLowestTemperature() {
		
		double theLowestTemperature = this.getTheWeatherData().getLowestTemperature().getTheMinimumTemperature();
		
		return theLowestTemperature;
	}
	
	/**
	 * Gets the highest temperature in the file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theHighestTemperature the highest temperature in the file
	 */
	
	public double getTheHighestTemperature() {
		
		double theHighestTemperature = this.getTheWeatherData().getHighestTemperature().getTheMaximumTemperature();
		
		return theHighestTemperature;
		
	}
	
	/**
	 * Gets the median temperature in the file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theMedianTemperature the median temperature in the file
	 */
	
	public double getTheMedianTemperature() {
		
		double theMedianTemperature = (this.getTheHighestTemperature() + this.getTheLowestTemperature()) / 2;
				
		return theMedianTemperature;
		
	}
	
	/**
	 * Gets the temperature between the median temperature and the lowest temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theTemperatureBetween the temperature between the median temperature and the lowest temperature
	 */
	
	public double getTemperatureBetweenMedianAndLowest() {
		
		double theTemperatureBetween = (this.getTheMedianTemperature() + this.getTheLowestTemperature()) / 2;
		
		return theTemperatureBetween;
		
	}
	
	/**
	 * Gets the temperature between the median temperature and the highest temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theTemperatureBetween the temperature between the median temperature and the highest temperature
	 */
	
	public double getTemperatureBetweenMedianAndHighest() {
		
		double theTemperatureBetween = (this.getTheMedianTemperature() + this.getTheHighestTemperature()) / 2;
		
		return theTemperatureBetween;
		
	}
	
	/**
	 * Gets the first date
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theFirstDay the first day in the weather data
	 */
	
	public String getTheFirstDay() {
		
		String theFirstDay = this.getTheWeatherData().getTheFirstDay().getTheDate();
		
		return theFirstDay;
		
	}
	
	/**
	 * Gets the middle date
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theMiddleDay the middle day in the weather data
	 */
	
	public String getTheMiddleDay() {
		
		String theMiddleDay = this.getTheWeatherData().getTheMiddleDay().getTheDate();
		
		return theMiddleDay;
		
	}
	
	/**
	 * Gets the last date
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theLastDay the last day in the weather data
	 */
	
	public String getTheLastDay() {
		
		String theLastDay = this.getTheWeatherData().getTheLastDay().getTheDate();
		
		return theLastDay;
		
	}
	
	/**
	 * Gets the first day low temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theFirstDayLow the low temperature for the first day
	 */
	
	public double getTheFirstDayLowTemperature() {
		
		double theFirstDayLow = this.getTheWeatherData().getTheFirstDay().getTheMinimumTemperature();
		
		return theFirstDayLow;
		
	}
	
	/**
	 * Gets the first day high temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theFirstDayHigh the high temperature for the first day
	 */
	
	public double getTheFirstDayHighTemperature() {
		
		double theFirstDayHigh = this.getTheWeatherData().getTheFirstDay().getTheMaximumTemperature();
		
		return theFirstDayHigh;
		
	}
	
	/**
	 * Gets the second day low temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theSecondDayLow the low temperature for the second day
	 */
	
	public double getTheSecondDayLowTemperature() {
		
		double theSecondDayLow = this.getTheWeatherData().getTheMiddleDay().getTheMinimumTemperature();
		
		return theSecondDayLow;
		
	}
	
	/**
	 * Gets the second day high temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theSecondDayHigh the high temperature for the second day
	 */
	
	public double getTheSecondDayHighTemperature() {
		
		double theSecondDayHigh = this.getTheWeatherData().getTheMiddleDay().getTheMaximumTemperature();
		
		return theSecondDayHigh;
		
	}
	
	/**
	 * Gets the third day low temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theThirdDayLow the low temperature for the third day
	 */
	
	public double getTheThirdDayLowTemperature() {
		
		double theSecondDayLow = this.getTheWeatherData().getTheLastDay().getTheMinimumTemperature();
		
		return theSecondDayLow;
		
	}
	
	/**
	 * Gets the third day high temperature
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theThirdDayHigh the high temperature for the third day
	 */
	
	public double getTheThirdDayHighTemperature() {
		
		double theThirdDayHigh = this.getTheWeatherData().getTheLastDay().getTheMaximumTemperature();
		
		return theThirdDayHigh;
		
	}
	
}
