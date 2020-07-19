package edu.westga.cs1302.weather.view;

import edu.westga.cs1302.weather.io.ReadWeatherFile;
import edu.westga.cs1302.weather.model.WeatherManager;

/**
 * The view model class for the weather project
 * 
 * @author Alex DeCesare
 * @version 16-July-2020
 */

public class WeatherViewModel {
	
	private WeatherManager theWeatherManager;
	private ReadWeatherFile theReadWeatherFile;
	
	/**
	 * The constructor for the view model
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public WeatherViewModel() {
		
		this.theWeatherManager = new WeatherManager();
		this.theReadWeatherFile = new ReadWeatherFile();
		
	}
	
	/**
	 * parses the file given as parameter
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param fileNameToSet the file name to set
	 */
	
	public void parseFile(String fileNameToSet) {
		
		this.theReadWeatherFile.setFileName(fileNameToSet);
		this.theReadWeatherFile.setTheFile();
		this.theReadWeatherFile.readFile();
	}
	
	/**
	 * Gets the parsed file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the parsed file
	 */
	
	public String setOutput() {
		
		return this.theReadWeatherFile.getTheWeatherManager().toString();
		
	}

}
