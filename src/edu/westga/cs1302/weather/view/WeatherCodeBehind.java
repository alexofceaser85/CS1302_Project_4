package edu.westga.cs1302.weather.view;

import java.io.File;
import java.nio.file.Paths;

import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * The code behind class for the weather project
 * 
 * @author Alex DeCesare
 * @version 16-July-2020
 */

public class WeatherCodeBehind {
	
	@FXML
	private Pane thePane;

    @FXML
    private MenuItem buttonOpenFile;

    @FXML
    private MenuItem buttonExit;

    @FXML
    private MenuItem buttonAbout;
    
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
		this.keyBindChooseFile();
		this.keyBindExitProgram();
	}
	
	/**
	 * Chooses the file to parse and sets it to the projects file path
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	@FXML
	public void chooseFile() {
		
		Window stage = this.thePane.getScene().getWindow();
		
		FileChooser theFileChooser = new FileChooser();
		String theCurrentFilePath = Paths.get(".").toAbsolutePath().normalize().toString();
		theFileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All Files", "*"),
				new FileChooser.ExtensionFilter("Only .txt Files", "*.txt")
		);
		
		theFileChooser.setInitialDirectory(new File(theCurrentFilePath));
		theFileChooser.showOpenDialog(stage);
		
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
	
	private void keyBindChooseFile() {
		
		this.buttonOpenFile.setMnemonicParsing(true);
		KeyCodeCombination theKeyCodeCombination = new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN);
		this.buttonOpenFile.setAccelerator(theKeyCodeCombination);
		
	}
	
	private void keyBindExitProgram() {
		this.buttonExit.setMnemonicParsing(true);
		KeyCodeCombination theKeyCodeCombination = new KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN);
		this.buttonExit.setAccelerator(theKeyCodeCombination);
	}

}