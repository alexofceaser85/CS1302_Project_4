package edu.westga.cs1302.weather.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestGetTheMiddleDay {

	@Test
	public void shouldThrowAnExceptionForEmptyManager() {
		
		WeatherManager theManager = new WeatherManager();
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			theManager.getTheMiddleDay();
		});
		
	}
	
	@Test
	public void shouldReturnTheMiddleWeatherForManagerWithOneWeather() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		
		theManager.addWeatherDay(theFirstWeather);
		
		assertEquals("The day: 2020-08-01 at the station: USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", theManager.getTheMiddleDay().toString());
	}
	
	@Test
	public void shouldReturnTheMiddleWeatherForMultipleWeathersOdd() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 80, 48);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 90, 70);
		
		theManager.addWeatherDay(theFirstWeather);
		theManager.addWeatherDay(theSecondWeather);
		theManager.addWeatherDay(theThirdWeather);
		
		assertEquals("The day: 2020-08-02 at the station: USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 80.0 with the minimum temperature of: 48.0", theManager.getTheMiddleDay().toString());
	}
	
	@Test
	public void shouldReturnTheMiddleWeatherForMultipleWeathersEven() {
		
		WeatherManager theManager = new WeatherManager();
		
		WeatherForADay theFirstWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-01", 92, 68);
		WeatherForADay theSecondWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-02", 80, 48);
		WeatherForADay theThirdWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 90, 70);
		WeatherForADay theFourthWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-08-03", 75, 40);
		
		theManager.addWeatherDay(theFirstWeather);
		theManager.addWeatherDay(theSecondWeather);
		theManager.addWeatherDay(theThirdWeather);
		theManager.addWeatherDay(theFourthWeather);
		
		assertEquals("The day: 2020-08-03 at the station: USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 90.0 with the minimum temperature of: 70.0", theManager.getTheMiddleDay().toString());
		
	}

}
