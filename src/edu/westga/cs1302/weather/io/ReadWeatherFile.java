package edu.westga.cs1302.weather.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This reads the weather file and gets the weather data
 * 
 * @author Alex DeCesare
 * @version 17-July-2020
 */

public class ReadWeatherFile {
	
	private static final String THE_FILE_NAME = "WeatherData.txt";
	private static final String THE_FILE_NOT_FOUND_WARNING = "The file was not found";
	
	private File theFile;
	private Scanner inFile;
	private WeatherManager theWeatherManager;
	
	/**
	 * The constructor for the read weather file class
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public ReadWeatherFile() {
		try {
			this.theFile = new File(THE_FILE_NAME);
			this.inFile = new Scanner(this.theFile);
			this.theWeatherManager = new WeatherManager();
			
		} catch (FileNotFoundException theFileNotFoundException) {
			Alert theAlert = new Alert(AlertType.WARNING);
			theAlert.setContentText(THE_FILE_NOT_FOUND_WARNING);
		}
	}
	
	/**
	 * Gets the in file scanner
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the in file scanner
	 */
	
	public Scanner getInFileScanner() {
		return this.inFile;
	}

}
