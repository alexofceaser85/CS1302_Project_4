package edu.westga.cs1302.weather.chart.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.chart.ChartData;
import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestGetLastDay {

	@Test
	public void shouldNotGetLastDayOfEmptyManager() {
		
		WeatherManager theManager = new WeatherManager();
		ChartData theChartData = new ChartData(theManager);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			assertEquals(null, theChartData.getTheLastDay());
		});
	}
	
	@Test
	public void shouldGetLastDayOfManagerWithOneDay() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theLastWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92.5, 68.5);
		
		theManager.addWeatherDay(theLastWeather);
		
		ChartData theChartData = new ChartData(theManager);
		
		assertEquals("2020-08-01", theChartData.getTheLastDay());
		
	}
	
	@Test
	public void shouldGetLastDayOfManagerWithMultipleDays() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theLastWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 91, 67);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 90, 66);
		
		theManager.addWeatherDay(theLastWeather);
		theManager.addWeatherDay(theSecondWeather);
		theManager.addWeatherDay(theThirdWeather);
		
		ChartData theChartData = new ChartData(theManager);
		
		assertEquals("2020-08-03", theChartData.getTheLastDay());
		
	}

}
