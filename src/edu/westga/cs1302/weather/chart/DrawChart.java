package edu.westga.cs1302.weather.chart;

import java.awt.Window;

import javafx.scene.control.Label;
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
	
	private Line theXAxis;
	private Line theYAxis;
	private ChartData theChartData;
	private Pane thePane;

	/**
	 * This class draws the chart
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param thePane the pane where the chart is
	 * @param theData the data for the chart
	 */
	
	public DrawChart(Pane thePane, ChartData theData) {
		
		//check if null
		
		super();
		
		this.theChartData = theData;
		this.thePane = thePane;
		this.thePane.getChildren().clear();
		this.theYAxis = new Line();
		this.theXAxis = new Line();
		
		this.drawXAxis(this.thePane);
		this.drawYAxis(this.thePane);
		this.drawFirstDay(this.thePane);
		this.drawSecondDay(this.thePane);
		this.drawThirdDay(this.thePane);
	}
	
	private void drawXAxis(Pane thePane) {
		
		this.theXAxis.endYProperty().bind(thePane.heightProperty().subtract(60));
		this.theXAxis.startYProperty().bind(thePane.heightProperty().subtract(60));
		this.theXAxis.endXProperty().bind(thePane.widthProperty());
		this.theXAxis.setStartX(60);

		thePane.getChildren().add(this.theXAxis);
	}
	
	private void drawYAxis(Pane thePane) {
		
		this.theYAxis.setRotate(270);
		this.theYAxis.startYProperty().bind(thePane.heightProperty().subtract(176));
		this.theYAxis.endYProperty().bind(thePane.heightProperty().subtract(176));
		this.theYAxis.setStartX(230);
		this.theYAxis.setEndX(0);
		this.theYAxis.setLayoutX(-55);

		thePane.getChildren().add(this.theYAxis);
	}
	
	private void drawFirstDay(Pane thePane) {
		
		Line theFirstDayMark = new Line();
		Label theFirstDayLabel = new Label();
		
		theFirstDayMark.setRotate(270);
		
		theFirstDayMark.startYProperty().bind(thePane.heightProperty().subtract(60));
		theFirstDayMark.endYProperty().bind(thePane.heightProperty().subtract(60));
		theFirstDayMark.setEndX(40);
		theFirstDayMark.setStartX(60);
		
		theFirstDayLabel.layoutYProperty().bind(thePane.heightProperty().subtract(50));
		theFirstDayLabel.layoutXProperty().bind(this.theXAxis.endXProperty().divide(4).add(this.theXAxis.getLayoutX()));
		
		theFirstDayMark.layoutXProperty().bind(this.theXAxis.endXProperty().divide(4).add(this.theXAxis.getLayoutX()));
		theFirstDayLabel.setText(this.theChartData.getTheFirstDay());
		
		thePane.getChildren().add(theFirstDayLabel);
		thePane.getChildren().add(theFirstDayMark);
		
	}
	
	private void drawSecondDay(Pane thePane) {
		
		Line theFirstDayMark = new Line();
		Label theSecondDayLabel = new Label();
		
		theFirstDayMark.setRotate(270);
		
		theFirstDayMark.startYProperty().bind(thePane.heightProperty().subtract(60));
		theFirstDayMark.endYProperty().bind(thePane.heightProperty().subtract(60));
		theFirstDayMark.setEndX(40);
		theFirstDayMark.setStartX(60);
		
		theSecondDayLabel.layoutYProperty().bind(thePane.heightProperty().subtract(50));
		theSecondDayLabel.layoutXProperty().bind(this.theXAxis.endXProperty().divide(4).multiply(2).add(this.theXAxis.getLayoutX()));
		
		theFirstDayMark.layoutXProperty().bind(this.theXAxis.endXProperty().divide(4).multiply(2).add(this.theXAxis.getLayoutX()));
		theSecondDayLabel.setText(this.theChartData.getTheMiddleDay());
		
		thePane.getChildren().add(theFirstDayMark);
		thePane.getChildren().add(theSecondDayLabel);
		
	}
	
	private void drawThirdDay(Pane thePane) {
		
		Line theFirstDayMark = new Line();
		Label theThirdDayLabel = new Label();
		
		theFirstDayMark.setRotate(270);
		
		theFirstDayMark.startYProperty().bind(thePane.heightProperty().subtract(60));
		theFirstDayMark.endYProperty().bind(thePane.heightProperty().subtract(60));
		theFirstDayMark.setEndX(40);
		theFirstDayMark.setStartX(60);
		
		theThirdDayLabel.layoutYProperty().bind(thePane.heightProperty().subtract(50));
		theThirdDayLabel.layoutXProperty().bind(this.theXAxis.endXProperty().divide(4).multiply(3).add(this.theXAxis.getLayoutX()));
		
		theFirstDayMark.layoutXProperty().bind(this.theXAxis.endXProperty().divide(4).multiply(3).add(this.theXAxis.getLayoutX()));
		
		theThirdDayLabel.setText(this.theChartData.getTheLastDay());
		
		thePane.getChildren().add(theFirstDayMark);
		thePane.getChildren().add(theThirdDayLabel);

	}
	
}
