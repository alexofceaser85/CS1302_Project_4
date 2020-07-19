package edu.westga.cs1302.weather.view;

import edu.westga.cs1302.weather.io.ReadWeatherFile;
import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

/**
 * The view model class for the weather project
 * 
 * @author Alex DeCesare
 * @version 16-July-2020
 */

public class WeatherViewModel {
	
	private ReadWeatherFile theReadWeatherFile;
	
	/**
	 * The constructor for the view model
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public WeatherViewModel() {
		
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
		
		WeatherManager theManager = this.theReadWeatherFile.getTheWeatherManager();
		
		String theOutput = "The File Name: " + this.theReadWeatherFile.getFileNameNoExtension()
				+ System.lineSeparator() + "---The First Day In The File---" 
				+ System.lineSeparator() + theManager.getTheFirstDay() 
				+ System.lineSeparator() + "---The Middle Day In The File---"
				+ System.lineSeparator() + theManager.getTheMiddleDay()
				+ System.lineSeparator() + "---The Last Day in The File---"
				+ System.lineSeparator() + theManager.getTheLastDay();
		
		return theOutput;
		
	}
	
	/**
	 * Gets the weather days that match a location
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param locationInput the location to find
	 * 
	 * @return the locations that match the location input
	 */
	
	public String setLocationOutput(String locationInput) {
		
		WeatherManager theManager = this.theReadWeatherFile.getTheWeatherManager();
		
		String output = "";
		
		if (!theManager.getWeatherWithMatchedLocation(locationInput).isEmpty()) {

			output = "--- The Locations That Match Location ---" + System.lineSeparator();
			
			for (WeatherForADay current : theManager.getWeatherWithMatchedLocation(locationInput)) {
				
				output += current.toString() + System.lineSeparator();	
			}	
		} else {
			output = "There are no locations that match";
		}
		
		return output;
		
	}

}
