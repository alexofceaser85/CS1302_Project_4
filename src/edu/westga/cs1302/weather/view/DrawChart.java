package edu.westga.cs1302.weather.view;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * This class draws the chart
 * 
 * @author Alex DeCesare
 * @version 20-July-2020
 */

public class DrawChart extends Pane {

	/**
	 * This class draws the chart
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public DrawChart() {
		super();
		
		Rectangle theRectangle = new Rectangle(0, 0, 20, 100);
		super.getChildren().add(theRectangle);
	}
	
}
