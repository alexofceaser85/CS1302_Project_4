package edu.westga.cs1302.weather.chart.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.chart.ChartData;
import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestGetMiddleDay {

	@Test
	public void shouldNotGetMiddleDayOfEmptyManager() {
		
		WeatherManager theManager = new WeatherManager();
		ChartData theChartData = new ChartData(theManager);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			assertEquals(null, theChartData.getTheMiddleDay());
		});
	}
	
	@Test
	public void shouldGetMiddleDayOfManagerWithOneDay() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theMiddleWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92.5, 68.5);
		
		theManager.addWeatherDay(theMiddleWeather);
		
		ChartData theChartData = new ChartData(theManager);
		
		assertEquals("2020-08-01", theChartData.getTheMiddleDay());
		
	}
	
	@Test
	public void shouldGetMiddleDayOfManagerWithMultipleDays() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theMiddleWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 91, 67);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 90, 66);
		
		theManager.addWeatherDay(theMiddleWeather);
		theManager.addWeatherDay(theSecondWeather);
		theManager.addWeatherDay(theThirdWeather);
		
		ChartData theChartData = new ChartData(theManager);
		
		assertEquals("2020-08-02", theChartData.getTheMiddleDay());
		
	}

}
