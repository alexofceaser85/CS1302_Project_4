package edu.westga.cs1302.weather.view;

import java.awt.Window;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
	 * 
	 * @param thePane the pane where the chart is
	 */
	
	public DrawChart(Pane thePane) {
		
		super();
		
		this.drawXAxis(thePane);
		this.drawYAxis(thePane);
	}
	
	private void drawXAxis(Pane thePane) {
		Line theXAxis = new Line();
		
		theXAxis.endYProperty().bind(thePane.heightProperty().subtract(60));
		theXAxis.startYProperty().bind(thePane.heightProperty().subtract(60));
		theXAxis.endXProperty().bind(thePane.widthProperty());
		theXAxis.setStartX(60);

		thePane.getChildren().add(theXAxis);
	}
	
	private void drawYAxis(Pane thePane) {
		Line theYAxis = new Line();
		
		theYAxis.setRotate(270);
		theYAxis.startYProperty().bind(thePane.heightProperty().subtract(176));
		theYAxis.endYProperty().bind(thePane.heightProperty().subtract(176));
		theYAxis.setStartX(230);
		theYAxis.setEndX(0);
		theYAxis.setLayoutX(-55);

		thePane.getChildren().add(theYAxis);
	}
	
}
