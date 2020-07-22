package edu.westga.cs1302.weather.view;

import java.io.File;
import java.text.DecimalFormat;

import edu.westga.cs1302.weather.chart.ChartData;
import edu.westga.cs1302.weather.chart.DrawChart;
import edu.westga.cs1302.weather.errormessages.ErrorMessages;
import edu.westga.cs1302.weather.io.ReadWeatherFile;
import edu.westga.cs1302.weather.io.SaveWeatherFile;
import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;
import javafx.scene.layout.Pane;

/**
 * The view model class for the weather project
 * 
 * @author Alex DeCesare
 * @version 16-July-2020
 */

public class WeatherViewModel {
	
	private ReadWeatherFile theReadWeatherFile;
	private ChartData theChartData;
	private DrawChart theChart;
	private SaveWeatherFile theSaveWeatherFile;
	
	/**
	 * The constructor for the view model
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public WeatherViewModel() {
		
		this.theReadWeatherFile = new ReadWeatherFile();
		this.theSaveWeatherFile = new SaveWeatherFile();
		
	}
	
	/**
	 * Saves the file given as a parameter
	 * 
	 * @precondition none
	 * @postcondition none 
	 * 
	 * @param theNewFile the file to save to
	 */
	
	public void saveFile(File theNewFile) {
		
		if (theNewFile == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_SAVE_TO_A_NULL_FILE);
		}
		
		this.theSaveWeatherFile.saveFile(theNewFile, this.theReadWeatherFile.getTheWeatherManager());
		
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
	 * Sets the output of the parsed file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the output of the parsed file
	 */
	
	public String setOutput() {
		
		WeatherManager theManager = this.theReadWeatherFile.getTheWeatherManager();
		
		String theOutput = this.getOutputHeader(theManager)
				+ System.lineSeparator()
				+ System.lineSeparator()
				+ this.getOutputBody(theManager);
		
		return theOutput;
	}
	
	/**
	 * 
	 * Draws the chart
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param theChartPane the chart pane to draw the chart on
	 * 
	 * @return theChart the chart to dray
	 */
	
	public DrawChart drawTheChart(Pane theChartPane) {
		
		this.theChartData = new ChartData(this.theReadWeatherFile.getTheWeatherManager());
		this.theChart = new DrawChart(theChartPane, this.theChartData);
		
		return this.theChart;
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
	
	private String roundToOneDecimals(double theDecimalToRound) {
		
		DecimalFormat theDecimalFormat = new DecimalFormat("##.0");
		
		return theDecimalFormat.format(theDecimalToRound);
		
	}
	
	private String roundToTwoDecimals(double theDecimalToRound) {
		
		DecimalFormat theDecimalFormat = new DecimalFormat("##.00");
		
		return theDecimalFormat.format(theDecimalToRound);
		
	}
	
	private String getOutputHeader(WeatherManager theManager) {
		
		String theHeader = "The File Name: " + this.theReadWeatherFile.getFileNameNoExtension()
			+ System.lineSeparator() + "---The Highest Temperature---"
			+ System.lineSeparator() + "Date: " + theManager.getHighestTemperature().getTheDate() + " Temperature: " + this.roundToOneDecimals(theManager.getHighestTemperature().getTheMaximumTemperature())
			+ System.lineSeparator() + "---The Lowest Temperature---"
			+ System.lineSeparator() + "Date: " + theManager.getLowestTemperature().getTheDate() + " Temperature: " + this.roundToOneDecimals(theManager.getLowestTemperature().getTheMinimumTemperature())
			+ System.lineSeparator() + "---The Average High Temperature---"
			+ System.lineSeparator() + this.roundToTwoDecimals(theManager.getTheAverageHighTemperature())
			+ System.lineSeparator() + "---The Average Low Temperature---"
			+ System.lineSeparator() + this.roundToTwoDecimals(theManager.getTheAverageLowTemperature());
		
		return theHeader;
	}
	
	private String getOutputBody(WeatherManager theManager) {
		String theBody = "---The First Day In The File---" 
				+ System.lineSeparator() + theManager.getTheFirstDay() 
				+ System.lineSeparator() + "---The Middle Day In The File---"
				+ System.lineSeparator() + theManager.getTheMiddleDay()
				+ System.lineSeparator() + "---The Last Day in The File---"
				+ System.lineSeparator() + theManager.getTheLastDay();

		return theBody;
	}
}
