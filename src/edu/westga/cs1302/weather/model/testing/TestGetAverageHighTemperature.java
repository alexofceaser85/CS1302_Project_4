package edu.westga.cs1302.weather.model.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestGetAverageHighTemperature {

	@Test
	public void shouldReturnNullForEmptyManager() {
		
		WeatherManager theManager = new WeatherManager();
		
		assertEquals(null, theManager.getHighestTemperature());
	
	}
	
	@Test
	public void shouldGetAverageOfHighestTemperatureWithOneDay() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		
		theTestManager.addWeatherDay(theWeather);
		
		assertEquals(92, theTestManager.getTheAverageHighTemperature());
	
	}
	
	@Test
	public void shouldGetAverageOfHighestTemperatureWithMultipleDaysOneBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 91, 67);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 90, 66);
		
		theTestManager.addWeatherDay(theFirstWeather);
		theTestManager.addWeatherDay(theSecondWeather);
		theTestManager.addWeatherDay(theThirdWeather);
		
		assertEquals(91, theTestManager.getTheAverageHighTemperature());
	
	}
	
	@Test
	public void shouldGetAverageOfHighestTemperatureWithMultipleDaysOneTenthBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92.5, 68.5);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 92.4, 67.4);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 92.3, 66.3);
		
		theTestManager.addWeatherDay(theFirstWeather);
		theTestManager.addWeatherDay(theSecondWeather);
		theTestManager.addWeatherDay(theThirdWeather);
		
		assertEquals(92.39999999999999, theTestManager.getTheAverageHighTemperature());
	
	}
	
	@Test
	public void shouldGetAverageOfHighestTemperatureWithMultipleDaysWellBetween() {
		
		WeatherManager theTestManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 104.5, 103.5);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 55.4, 50.4);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 20.3, 15.3);
		
		theTestManager.addWeatherDay(theFirstWeather);
		theTestManager.addWeatherDay(theSecondWeather);
		theTestManager.addWeatherDay(theThirdWeather);
		
		assertEquals(60.06666666666667, theTestManager.getTheAverageHighTemperature());
	
	}

}
