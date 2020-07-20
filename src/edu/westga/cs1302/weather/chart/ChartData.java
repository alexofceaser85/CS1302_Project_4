package edu.westga.cs1302.weather.chart;

import java.io.FileReader;

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
		
		System.out.println(this.theWeatherData);
		
	}
	
}
