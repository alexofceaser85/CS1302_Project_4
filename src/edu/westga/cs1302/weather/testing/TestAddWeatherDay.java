package edu.westga.cs1302.weather.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestAddWeatherDay {

	@Test
	public void shouldNotAddNullWeatherForDay() {
		
		WeatherManager theManager = new WeatherManager();

		assertThrows(IllegalArgumentException.class, () -> {
			
			theManager.addWeatherDay(null);
			
		});
	}
	
	public void shouldAddWeatherDayToEmptyManager() {
		
		WeatherManager theManager = new WeatherManager();
		WeatherForADay theDaysWeather = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-01", 92, 68);
		
		theManager.addWeatherDay(theDaysWeather);
		
		assertEquals("USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 92.0 with the minimum temperature of: 68.0"
				+ System.lineSeparator(), theManager.toString());
	}
	
	public void shouldAddMultipleWeatherDays() {
		
		WeatherManager theManager = new WeatherManager();
		WeatherForADay theFirstDaysWeather = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-01", 92, 68);
		WeatherForADay theSecondDaysWeather = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-02", 90, 71);
		WeatherForADay theThirdDaysWeather = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-03", 85, 40);
		
		theManager.addWeatherDay(theFirstDaysWeather);
		theManager.addWeatherDay(theSecondDaysWeather);
		theManager.addWeatherDay(theThirdDaysWeather);
		
		assertEquals("USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 92.0 with the minimum temperature of: 68.0"
				+ System.lineSeparator() + "USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 90.0 with the minimum temperature of: 71.0"
				+ System.lineSeparator() + "USC00091640 at the location: CARROLLTON GA US with the maximum temperature of: 85.0 with the minimum temperature of: 40.0"
				+ System.lineSeparator(), theManager.toString());
	}

}
