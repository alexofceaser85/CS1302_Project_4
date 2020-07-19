package edu.westga.cs1302.weather.view;

import edu.westga.cs1302.weather.io.ReadWeatherFile;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * The view model class for the weather project
 * 
 * @author Alex DeCesare
 * @version 16-July-2020
 */

public class WeatherViewModel {
	
	private static final String ALERT_PARSE_FILE_ERROR_TITLE = "There was an error"; 
	
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
		
		try {
			this.theReadWeatherFile.setFileName(fileNameToSet);
			this.theReadWeatherFile.setTheFile();
			this.theReadWeatherFile.readFile();
		} catch (IllegalArgumentException theIllegalArgumentException) {
			Alert theAlert = new Alert(AlertType.ERROR);
			theAlert.setTitle(ALERT_PARSE_FILE_ERROR_TITLE);
			theAlert.setContentText(theIllegalArgumentException.getMessage());
			theAlert.showAndWait();
		}

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
