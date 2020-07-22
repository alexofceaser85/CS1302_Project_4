package edu.westga.cs1302.weather.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This saves the weather file
 * 
 * @author Alex DeCesare
 * @version 21-July-2020
 */

public class SaveWeatherFile {

	private static final String THE_FILE_WAS_NOT_FOUND = "The File Was Not Found";
	
	/**
	 * The constructor for the save weather file
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public SaveWeatherFile() {
		
	}
	
	/**
	 * Saves the file 
	 * 
	 * @precondition theFileToSave != null
	 * @postcondition none
	 * 
	 * @param theFileToSave the new file to add
	 * @param theWeatherData the weather data
	 */
	
	public void saveFile(File theFileToSave, WeatherManager theWeatherData) {
		
		try {
			File theFile = new File(theFileToSave.getAbsolutePath());
			String data = "";
			
			PrintWriter savedFile = new PrintWriter(theFile);
			
			for (WeatherForADay current : theWeatherData.getTheSortedWeather()) {
				data += current.toString() + System.lineSeparator();
			}

			savedFile.write(data);
			savedFile.close();
			
		} catch (FileNotFoundException theFileNotFoundException) {
			
			Alert theAlert = new Alert(AlertType.ERROR);
			theAlert.setContentText(THE_FILE_WAS_NOT_FOUND);
			theAlert.showAndWait();
			
		}
		
	}
	
}
