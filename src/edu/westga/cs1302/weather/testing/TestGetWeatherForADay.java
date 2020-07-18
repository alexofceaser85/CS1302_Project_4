package edu.westga.cs1302.weather.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestGetWeatherForADay {

	@Test
	public void shouldNotFromNullKey() {
		
		WeatherManager theManager = new WeatherManager();
		
		assertThrows(IllegalArgumentException.class, () -> {
			
			theManager.getWeatherForADay(null);
			
		});
		
	}
	
	@Test
	public void shouldNotFromEmptyKey() {
		
		WeatherManager theManager = new WeatherManager();
		
		assertThrows(IllegalArgumentException.class, () -> {
			
			theManager.getWeatherForADay("");
			
		});
		
	}
	
	@Test
	public void shouldReturnNullForEmptyManager() {
		
		WeatherManager theManager = new WeatherManager();
		
		assertEquals(null, theManager.getWeatherForADay("2020-07-01"));
		
	}
	
	@Test
	public void shouldReturnNullForManagerWithOneDayNoMatch() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("uSC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("uSC00091640", "CARROLLTON GA US", "2020-09-01", 90, 65);
		
		theManager.addWeatherDay(theFirstWeather);
		theManager.addWeatherDay(theSecondWeather);
		
		assertEquals(null, theManager.getWeatherForADay("2020-07-01"));
		
	}
	
	@Test
	public void shouldReturnNullForManagerWithMultipleDaysNoMatch() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("uSC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("uSC00091640", "CARROLLTON GA US", "2020-09-01", 90, 65);
		WeatherForADay theThirdWeather = new WeatherForADay("uSC00091640", "CARROLLTON GA US", "2020-10-01", 92, 68);
		
		theManager.addWeatherDay(theFirstWeather);
		theManager.addWeatherDay(theSecondWeather);
		theManager.addWeatherDay(theThirdWeather);
		
		assertEquals(null, theManager.getWeatherForADay("2020-07-01"));
		
	}
	
	@Test
	public void shouldFindFirstDayInManager() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-09-01", 90, 65);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-10-01", 92, 68);
		
		theManager.addWeatherDay(theFirstWeather);
		theManager.addWeatherDay(theSecondWeather);
		theManager.addWeatherDay(theThirdWeather);
		
		assertEquals("The day: 2020-08-01 at the station: USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", theManager.getWeatherForADay("2020-08-01").toString());
	}
	
	@Test
	public void shouldFindMiddleDayInManager() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-09-01", 90, 65);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-10-01", 92, 68);
		
		theManager.addWeatherDay(theFirstWeather);
		theManager.addWeatherDay(theSecondWeather);
		theManager.addWeatherDay(theThirdWeather);
		
		assertEquals("The day: 2020-09-01 at the station: USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 90.0 with the minimum temperature of: 65.0", theManager.getWeatherForADay("2020-09-01").toString());
	}
	
	@Test
	public void shouldFindLastDayInManager() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-09-01", 90, 65);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-10-01", 92, 68);
		
		theManager.addWeatherDay(theFirstWeather);
		theManager.addWeatherDay(theSecondWeather);
		theManager.addWeatherDay(theThirdWeather);
		
		assertEquals("The day: 2020-10-01 at the station: USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", theManager.getWeatherForADay("2020-10-01").toString());
	}
	
}
