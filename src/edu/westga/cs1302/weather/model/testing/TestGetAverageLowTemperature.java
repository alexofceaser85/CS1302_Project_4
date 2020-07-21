package edu.westga.cs1302.weather.model.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestGetAverageLowTemperature {

	@Test
	public void shouldReturnNullForEmptyManager() {
		
		WeatherManager theManager = new WeatherManager();
		
		assertEquals(null, theManager.getLowestTemperature());
	
	}
	
	@Test
	public void shouldGetAverageOfLowestTemperatureWithOneDay() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		
		theTestManager.addWeatherDay(theWeather);
		
		assertEquals(68.0, theTestManager.getTheAverageLowTemperature());
	
	}
	
	@Test
	public void shouldGetAverageOfLowestTemperatureWithMultipleDaysOneBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 91, 67);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 90, 66);
		
		theTestManager.addWeatherDay(theFirstWeather);
		theTestManager.addWeatherDay(theSecondWeather);
		theTestManager.addWeatherDay(theThirdWeather);
		
		assertEquals(67, theTestManager.getTheAverageLowTemperature());
	
	}
	
	@Test
	public void shouldGetAverageOfLowestTemperatureWithMultipleDaysOneTenthBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92.5, 68.5);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 92.4, 67.4);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 92.3, 66.3);
		
		theTestManager.addWeatherDay(theFirstWeather);
		theTestManager.addWeatherDay(theSecondWeather);
		theTestManager.addWeatherDay(theThirdWeather);
		
		assertEquals(67.39999999999999, theTestManager.getTheAverageLowTemperature());
	
	}
	
	@Test
	public void shouldGetAverageOfLowestTemperatureWithMultipleDaysWellBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 104.5, 103.5);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 55.4, 50.4);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 20.3, 15.3);
		
		theTestManager.addWeatherDay(theFirstWeather);
		theTestManager.addWeatherDay(theSecondWeather);
		theTestManager.addWeatherDay(theThirdWeather);
		
		assertEquals(56.400000000000006, theTestManager.getTheAverageLowTemperature());
	
	}
}
