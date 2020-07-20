package edu.westga.cs1302.weather.view;

import java.io.File;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * The code behind class for the weather project
 * 
 * @author Alex DeCesare
 * @version 16-July-2020
 */

public class WeatherCodeBehind extends Pane {
	
	private static final String INFORMATION_ALERT_TITLE = "Weather Parser by Alex DeCesare";
	private static final String INFORMATION_ALERT_CONTENT_TEXT = "This program parses weather data which is split by new lines for each day and double quotes for each peice of data";
	private static final String NO_FILE_SELECTED_TITLE = "There is no file selected";
	private static final String NO_FILE_SELECTED_CONTENT_TEXT = "Please select a file to parse";
	private static final String ARRAY_OUT_OF_BOUNDS_FILE_SELECTED_TITLE = "There was a problem parsing this file";
	private static final String ARRAY_OUT_OF_BOUNDS_FILE_SELECTED_CONTENT_TEXT = "The format to parse this file is not valid";
	
    @FXML
    private HBox thePane;

    @FXML
    private MenuItem buttonOpenFile;

    @FXML
    private MenuItem buttonExit;

    @FXML
    private MenuItem buttonAbout;

    @FXML
    private TextArea textAreaTheLocationInput;

    @FXML
    private Label labelTheOutput;

    @FXML
    private Pane chartPane;
    
	private WeatherViewModel theWeatherViewModel;
	
	/**
	 * The constructor for the code behind method
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public WeatherCodeBehind() {
	
		this.theWeatherViewModel = new WeatherViewModel();
		
	}
	
	@FXML
	private void initialize() {

	}
	
	/**
	 * Chooses the file to parse and sets it to the projects file path
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	@FXML
	public void chooseFile() {
		
		try {
			Window stage = this.thePane.getScene().getWindow();
			
			FileChooser theFileChooser = new FileChooser();
			
			this.setFileChooserProperties(theFileChooser);
			
			File theFile = theFileChooser.showOpenDialog(stage);
			
			this.theWeatherViewModel.parseFile(theFile.getAbsolutePath());
			
			this.displayOutput();
			this.displayChart();
		} catch (NullPointerException theNullPointerException) {
			Alert theAlert = new Alert(AlertType.INFORMATION);
			theAlert.setTitle(NO_FILE_SELECTED_TITLE);
			theAlert.setContentText(NO_FILE_SELECTED_CONTENT_TEXT);
			theAlert.showAndWait();
		} catch (ArrayIndexOutOfBoundsException theArrayOutOfBoundsException) {
			Alert theAlert = new Alert(AlertType.ERROR);
			theAlert.setTitle(ARRAY_OUT_OF_BOUNDS_FILE_SELECTED_TITLE);
			theAlert.setContentText(ARRAY_OUT_OF_BOUNDS_FILE_SELECTED_CONTENT_TEXT);
			theAlert.showAndWait();
		}

	}
	
	/**
	 * Exits out of the application
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void exitTheApplication() {
		System.exit(0);
	}
	
	/**
	 * Displays the output to the gui
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void displayOutput() {
		
		this.labelTheOutput.setText(this.theWeatherViewModel.setOutput());
		
	}
	
	/**
	 * Displays the chart to the gui
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void displayChart() {
		
		DrawChart theChart = new DrawChart();
		
		this.chartPane.getChildren().add(theChart);	
				
	}
	
	/**
	 * displays the locations found to the gui
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void displayLocationOutput() {
		
		if (!this.textAreaTheLocationInput.getText().isEmpty()) {
			this.labelTheOutput.setText(this.theWeatherViewModel.setLocationOutput(this.textAreaTheLocationInput.getText()));
		}
		
	}
	
	/**
	 * Displays an about section 
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public void displayAboutTheApplication() {
		Alert theAlert = new Alert(AlertType.INFORMATION);
		theAlert.setTitle(INFORMATION_ALERT_TITLE);
		theAlert.setContentText(INFORMATION_ALERT_CONTENT_TEXT);
		theAlert.showAndWait();
	}
	
	private void setFileChooserProperties(FileChooser theFileChooser) {
		String theCurrentFilePath = Paths.get(".").toAbsolutePath().normalize().toString();
		theFileChooser.setInitialDirectory(new File(theCurrentFilePath + "/src"));
		theFileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All Files", "*"),
				new FileChooser.ExtensionFilter("Only .txt Files", "*.txt")
		);
	}

}