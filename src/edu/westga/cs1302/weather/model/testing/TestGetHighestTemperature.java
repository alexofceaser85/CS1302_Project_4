package edu.westga.cs1302.weather.model.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestGetHighestTemperature {

	@Test
	public void shouldReturnNullForEmptyManager() {
		
		WeatherManager theManager = new WeatherManager();
		
		assertEquals(null, theManager.getHighestTemperature());
	
	}
	
	@Test
	public void shouldHighestTemperatureForManagerWithOneDay() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		
		theTestManager.addWeatherDay(theWeather);
		
		assertEquals(theWeather, theTestManager.getHighestTemperature());
	
	}
	
	@Test
	public void shouldHighestTemperatureForManagerWithMultipleDaysOneBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theHighestWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theMiddleWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 91, 67);
		WeatherForADay theLowestWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 90, 66);
		
		theTestManager.addWeatherDay(theHighestWeather);
		theTestManager.addWeatherDay(theMiddleWeather);
		theTestManager.addWeatherDay(theLowestWeather);
		
		assertEquals(theHighestWeather, theTestManager.getHighestTemperature());
	
	}
	
	@Test
	public void shouldHighestTemperatureForManagerWithMultipleDaysOneTenthBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theHighestWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92.5, 68.5);
		WeatherForADay theMiddleWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 92.4, 67.4);
		WeatherForADay theLowestWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 92.3, 66.3);
		
		theTestManager.addWeatherDay(theHighestWeather);
		theTestManager.addWeatherDay(theMiddleWeather);
		theTestManager.addWeatherDay(theLowestWeather);
		
		assertEquals(theHighestWeather, theTestManager.getHighestTemperature());
	
	}
	
	@Test
	public void shouldHighestTemperatureForManagerWithMultipleDaysWellBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theHighestWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 104.5, 103.5);
		WeatherForADay theMiddleWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 55.4, 50.4);
		WeatherForADay theLowestWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 20.3, 15.3);
		
		theTestManager.addWeatherDay(theHighestWeather);
		theTestManager.addWeatherDay(theMiddleWeather);
		theTestManager.addWeatherDay(theLowestWeather);
		
		assertEquals(theHighestWeather, theTestManager.getHighestTemperature());
	
	}

}
