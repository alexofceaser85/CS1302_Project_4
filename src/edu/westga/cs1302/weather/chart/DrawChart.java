package edu.westga.cs1302.weather.chart;

import java.text.DecimalFormat;

import edu.westga.cs1302.weather.errormessages.ErrorMessages;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

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
	private Line theHighestTemperatureMark;
	private Line theLowestTemperatureMark;

	/**
	 * This class draws the chart
	 * 
	 * @precondition thePane != null && theData != null
	 * @postcondition none
	 * 
	 * @param thePane the pane where the chart is
	 * @param theData the data for the chart
	 */
	
	public DrawChart(Pane thePane, ChartData theData) {
		
		super();
		
		if (thePane == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_DRAW_A_CHART_ON_A_NULL_CHART_PANE);
		}
		if (theData == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_DRAW_A_CHART_BASED_ON_NULL_DATA);
		}
		
		this.theChartData = theData;
		this.thePane = thePane;
		this.thePane.getChildren().clear();
		this.theYAxis = new Line();
		this.theXAxis = new Line();

		this.drawXAxis();
		this.drawYAxis();
		this.drawTemperatureForEachDay();
		this.drawAverageHighTemperature(this.thePane);
		this.drawAverageLowTemperature(this.thePane);
	}

	private void drawXAxis() {
		this.drawXAxis(this.thePane);
		this.drawYAxis(this.thePane);
		this.drawFirstDay(this.thePane);
		this.drawSecondDay(this.thePane);
		this.drawThirdDay(this.thePane);
	}

	private void drawYAxis() {
		this.drawLowestTemperature(this.thePane);
		this.drawTemperatureBetweenLowestAndMedian(this.thePane);
		this.drawMedianTemperature(this.thePane);
		this.drawTemperatureBetweenHighestAndMedian(this.thePane);
		this.drawHighestTemperature(this.thePane);
	}

	private void drawTemperatureForEachDay() {
		this.drawLowTemperatureForFirstDay(this.thePane);
		this.drawHighTemperatureForFirstDay(this.thePane);
		this.drawHighTemperatureForSecondDay(this.thePane);
		this.drawLowTemperatureForSecondDay(this.thePane);
		this.drawHighTemperatureForThirdDay(this.thePane);
		this.drawLowTemperatureForThirdDay(this.thePane);
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
	
	private void drawLowestTemperature(Pane thePane) {
		
		this.theLowestTemperatureMark = new Line();
		Label theLowestTemperatureLabel = new Label();
		
		this.theLowestTemperatureMark.layoutYProperty().bind(this.theYAxis.endYProperty().add(100));
		theLowestTemperatureLabel.layoutYProperty().bind(this.theYAxis.endYProperty().add(90));
		
		theLowestTemperatureLabel.setText(this.formatDouble(this.theChartData.getTheLowestTemperature()));
		
		this.theLowestTemperatureMark.setEndX(50);
		this.theLowestTemperatureMark.setStartX(70);
		
		thePane.getChildren().add(this.theLowestTemperatureMark);
		thePane.getChildren().add(theLowestTemperatureLabel);
	}
	
	private void drawTemperatureBetweenLowestAndMedian(Pane thePane) {
		
		Line theBetweenLowestAndMedianMark = new Line();
		Label betweenLowAndMedianTemperatureLabel = new Label();
		
		theBetweenLowestAndMedianMark.layoutYProperty().bind(this.theYAxis.endYProperty().add(50));
		betweenLowAndMedianTemperatureLabel.layoutYProperty().bind(this.theYAxis.endYProperty().add(40));
		
		theBetweenLowestAndMedianMark.setEndX(50);
		theBetweenLowestAndMedianMark.setStartX(70);
		
		betweenLowAndMedianTemperatureLabel.setText(this.formatDouble(this.theChartData.getTemperatureBetweenMedianAndLowest()));
		
		thePane.getChildren().add(theBetweenLowestAndMedianMark);
		thePane.getChildren().add(betweenLowAndMedianTemperatureLabel);
	}
	
	private void drawMedianTemperature(Pane thePane) {
		
		Line theMedianTemperatureMark = new Line();
		Label theMedianTemperatureLabel = new Label();
		
		theMedianTemperatureMark.layoutYProperty().bind(this.theYAxis.endYProperty());
		theMedianTemperatureLabel.layoutYProperty().bind(this.theYAxis.endYProperty().subtract(10));
		
		theMedianTemperatureLabel.setText(this.formatDouble(this.theChartData.getTheMedianTemperature()));
		theMedianTemperatureMark.setEndX(70);
		theMedianTemperatureMark.setStartX(50);
		
		thePane.getChildren().add(theMedianTemperatureMark);
		thePane.getChildren().add(theMedianTemperatureLabel);
	}
	
	private void drawTemperatureBetweenHighestAndMedian(Pane thePane) {
		
		Line betweenHighestAndMedianMark = new Line();
		Label betweenHighestAndMedianTemperatureLabel = new Label();
		
		betweenHighestAndMedianMark.layoutYProperty().bind(this.theYAxis.endYProperty().subtract(50));
		betweenHighestAndMedianTemperatureLabel.layoutYProperty().bind(this.theYAxis.endYProperty().subtract(60));
		
		betweenHighestAndMedianTemperatureLabel.setText(this.formatDouble(this.theChartData.getTemperatureBetweenMedianAndHighest()));
		
		betweenHighestAndMedianMark.setEndX(50);
		betweenHighestAndMedianMark.setStartX(70);
		
		thePane.getChildren().add(betweenHighestAndMedianMark);
		thePane.getChildren().add(betweenHighestAndMedianTemperatureLabel);
	}
	
	private void drawHighestTemperature(Pane thePane) {
		
		this.theHighestTemperatureMark = new Line();
		Label theHighestTemperatureLabel = new Label();
		
		this.theHighestTemperatureMark.layoutYProperty().bind(this.theYAxis.endYProperty().subtract(100));
		theHighestTemperatureLabel.layoutYProperty().bind(this.theYAxis.endYProperty().subtract(110));
		
		theHighestTemperatureLabel.setText(this.formatDouble(this.theChartData.getTheHighestTemperature()));
		
		this.theHighestTemperatureMark.setEndX(50);
		this.theHighestTemperatureMark.setStartX(70);
		
		thePane.getChildren().add(this.theHighestTemperatureMark);
		thePane.getChildren().add(theHighestTemperatureLabel);
	}
	
	private void drawLowTemperatureForFirstDay(Pane thePane) {
		
		Circle theCircle = new Circle();
		theCircle.setFill(Color.BLUE);
		
		theCircle.setRadius(5);
		theCircle.layoutXProperty().bind(this.theXAxis.endXProperty().divide(3).add(this.theXAxis.getLayoutX()));
		theCircle.layoutYProperty().bind(this.theYAxis.startYProperty().add(this.theYAxis.getStartY()));
		
		theCircle.setTranslateY(-15 - this.getTemperatureAndHeightRatio(this.theChartData.getTheFirstDayLowTemperature()) * this.theXAxis.getEndY());
		
		thePane.getChildren().add(theCircle);
	}
	
	private void drawHighTemperatureForFirstDay(Pane thePane) {
		
		Circle theCircle = new Circle();
		theCircle.setFill(Color.RED);
		
		theCircle.setRadius(5);
		theCircle.layoutXProperty().bind(this.theXAxis.endXProperty().divide(3).add(this.theXAxis.getLayoutX()));
		theCircle.layoutYProperty().bind(this.theYAxis.startYProperty().add(this.theYAxis.getStartY()));
		
		theCircle.setTranslateY(15 - this.getTemperatureAndHeightRatio(this.theChartData.getTheFirstDayHighTemperature()) * this.theXAxis.getEndY());
		
		thePane.getChildren().add(theCircle);
	}
	
	private void drawLowTemperatureForSecondDay(Pane thePane) {
		
		Circle theCircle = new Circle();
		theCircle.setFill(Color.BLUE);
		
		theCircle.setRadius(5);
		theCircle.layoutXProperty().bind(this.theXAxis.endXProperty().divide(5).multiply(3).add(this.theXAxis.getLayoutX()));
		theCircle.layoutYProperty().bind(this.theYAxis.startYProperty().add(this.theYAxis.getStartY()));
		
		theCircle.setTranslateY(-15 - (this.getTemperatureAndHeightRatio(this.theChartData.getTheSecondDayLowTemperature()) * this.theXAxis.getEndY()));
		
		thePane.getChildren().add(theCircle);
	}
	
	private void drawHighTemperatureForSecondDay(Pane thePane) {
		
		Circle theCircle = new Circle();
		theCircle.setFill(Color.RED);
		
		theCircle.setRadius(5);
		theCircle.layoutXProperty().bind(this.theXAxis.endXProperty().divide(5).multiply(3).add(this.theXAxis.getLayoutX()));
		theCircle.layoutYProperty().bind(this.theYAxis.startYProperty().add(this.theYAxis.getStartY()));
		
		System.out.println(theCircle.getLayoutY());
		
		theCircle.setTranslateY((15 - this.getTemperatureAndHeightRatio(this.theChartData.getTheSecondDayHighTemperature()) * this.theXAxis.getEndY()));
		
		thePane.getChildren().add(theCircle);
	}
	
	private void drawLowTemperatureForThirdDay(Pane thePane) {
		
		Circle theCircle = new Circle();
		theCircle.setFill(Color.BLUE);
		
		theCircle.setRadius(5);
		theCircle.layoutXProperty().bind(this.theXAxis.endXProperty().divide(6).multiply(5).add(this.theXAxis.getLayoutX()));
		theCircle.layoutYProperty().bind(this.theYAxis.startYProperty().add(this.theYAxis.getStartY()));
		
		theCircle.setTranslateY(-15 - (this.getTemperatureAndHeightRatio(this.theChartData.getTheThirdDayLowTemperature()) * this.theXAxis.getEndY()));
		
		thePane.getChildren().add(theCircle);
	}
	
	private void drawHighTemperatureForThirdDay(Pane thePane) {
		
		Circle theCircle = new Circle();
		theCircle.setFill(Color.RED);
		
		theCircle.setRadius(5);
		theCircle.layoutXProperty().bind(this.theXAxis.endXProperty().divide(6).multiply(5).add(this.theXAxis.getLayoutX()));
		theCircle.layoutYProperty().bind(this.theYAxis.startYProperty().add(this.theYAxis.getStartY()));
		
		theCircle.setTranslateY((15 - this.getTemperatureAndHeightRatio(this.theChartData.getTheThirdDayHighTemperature()) * this.theXAxis.getEndY()));
		
		thePane.getChildren().add(theCircle);
	}
	
	private void drawAverageHighTemperature(Pane thePane) {
		
		Line theLine = new Line();
		theLine.setFill(Color.RED);
		
		theLine.endYProperty().bind(thePane.heightProperty().subtract(60));
		theLine.startYProperty().bind(thePane.heightProperty().subtract(60));
		theLine.endXProperty().bind(thePane.widthProperty());
		theLine.setStartX(60);
		
		theLine.setTranslateY(0 - this.getTemperatureAndHeightRatio(this.theChartData.getTheWeatherData().getTheAverageHighTemperature()) * this.theXAxis.getEndY());
		
		thePane.getChildren().add(theLine);
		
	}
	
	private void drawAverageLowTemperature(Pane thePane) {
		
		Line theLine = new Line();
		theLine.setFill(Color.BLUE);
		
		theLine.endYProperty().bind(thePane.heightProperty().subtract(60));
		theLine.startYProperty().bind(thePane.heightProperty().subtract(60));
		theLine.endXProperty().bind(thePane.widthProperty());
		theLine.setStartX(60);
		
		theLine.setTranslateY(0 - this.getTemperatureAndHeightRatio(this.theChartData.getTheWeatherData().getTheAverageLowTemperature()) * this.theXAxis.getEndY());
		
		thePane.getChildren().add(theLine);
		
	}
	
	private String formatDouble(double theDoubleToConvert) {
		
		DecimalFormat theDecimalFormat = new DecimalFormat("##.00");
		
		return theDecimalFormat.format(theDoubleToConvert);
		
	}
	
	private double getTemperatureAndHeightRatio(double theCurrentTemperature) {

		return (theCurrentTemperature - this.theChartData.getTheLowestTemperature()) / (this.theChartData.getTheHighestTemperature() - this.theChartData.getTheLowestTemperature());
		
	}
	
}
