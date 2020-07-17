package edu.westga.cs1302.weather.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs1302.weather.model.WeatherForADay;
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
	
	private ArrayList<WeatherForADay> theDailyWeather;
	private File theFile;
	private Scanner inFile;
	
	/**
	 * The constructor for the read weather file class
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public ReadWeatherFile() {
		try {
			this.theDailyWeather = new ArrayList<WeatherForADay>();
			this.theFile = new File(THE_FILE_NAME);
			this.inFile = new Scanner(this.theFile);
			
		} catch (FileNotFoundException theFileNotFoundException) {
			Alert theAlert = new Alert(AlertType.WARNING);
			theAlert.setContentText(THE_FILE_NOT_FOUND_WARNING);
		}
	}

}
