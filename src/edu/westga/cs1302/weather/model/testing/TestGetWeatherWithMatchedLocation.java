package edu.westga.cs1302.weather.model.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.model.WeatherForADay;
import edu.westga.cs1302.weather.model.WeatherManager;

class TestGetWeatherWithMatchedLocation {

	@Test
	public void shouldNotFindNullLocation() {
		WeatherManager theWeatherManager = new WeatherManager();
		
		assertThrows(IllegalArgumentException.class, () -> {
			theWeatherManager.getWeatherWithMatchedLocation(null);
		});
	}
	
	@Test
	public void shouldNotFindEmptyLocation() {
		WeatherManager theWeatherManager = new WeatherManager();
		
		assertThrows(IllegalArgumentException.class, () -> {
			theWeatherManager.getWeatherWithMatchedLocation("");
		});
	}
	
	@Test
	public void shouldReturnEmptyArrayForEmptyManager() {
		WeatherManager theTestWeatherManager = new WeatherManager();

		assertEquals(true, theTestWeatherManager.getWeatherWithMatchedLocation("newnan ga").isEmpty());

	}
	
	@Test
	public void shouldReturnEmptyArrayForManagerWithOneDayNoMatch() {
		WeatherManager theTestWeatherManager = new WeatherManager();
		WeatherForADay theWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-05", 92, 71);

		theTestWeatherManager.addWeatherDay(theWeatherForADay);
		
		assertEquals(true, theTestWeatherManager.getWeatherWithMatchedLocation("NEWNAN GA US").isEmpty());

	}
	
	@Test
	public void shouldReturnEmptyArrayForManagerWithMultipleDaysNoMatch() {
		WeatherManager theTestWeatherManager = new WeatherManager();
		WeatherForADay firstWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-05", 92, 71);
		WeatherForADay secondWeatherForADay = new WeatherForADay("USC00091640", "DOUGLASVILLE, GA US", "2020-07-06", 80, 70);
		WeatherForADay thirdWeatherForADay = new WeatherForADay("USC00091640", "ATLANTA, GA US", "2020-07-07", 85, 65);

		theTestWeatherManager.addWeatherDay(firstWeatherForADay);
		theTestWeatherManager.addWeatherDay(secondWeatherForADay);
		theTestWeatherManager.addWeatherDay(thirdWeatherForADay);
		
		assertEquals(true, theTestWeatherManager.getWeatherWithMatchedLocation("NEWNAN GA US").isEmpty());

	}
	
	@Test
	public void shouldReturnMatchedArraysForManagerWithOneDayMatch() {
		WeatherManager theTestWeatherManager = new WeatherManager();
		WeatherManager theTestAgainstWeatherManager = new WeatherManager();
		WeatherForADay theWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-05", 92, 71);

		theTestWeatherManager.addWeatherDay(theWeatherForADay);
		theTestAgainstWeatherManager.addWeatherDay(theWeatherForADay);
		
		assertEquals(theTestAgainstWeatherManager.getTheSortedWeather(), theTestWeatherManager.getWeatherWithMatchedLocation("CARROLLTON, GA US"));
	}
	
	@Test
	public void shouldReturnMatchedArrayForManagerWithMultipleDaysOneMatch() {
		WeatherManager theTestWeatherManager = new WeatherManager();
		WeatherManager theTestAgainstWeatherManager = new WeatherManager();
		
		WeatherForADay firstWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-05", 92, 71);
		WeatherForADay secondWeatherForADay = new WeatherForADay("USC00091640", "DOUGLASVILLE, GA US", "2020-07-06", 80, 70);
		WeatherForADay thirdWeatherForADay = new WeatherForADay("USC00091640", "ATLANTA, GA US", "2020-07-07", 85, 65);

		theTestWeatherManager.addWeatherDay(firstWeatherForADay);
		theTestWeatherManager.addWeatherDay(secondWeatherForADay);
		theTestWeatherManager.addWeatherDay(thirdWeatherForADay);
		
		theTestAgainstWeatherManager.addWeatherDay(firstWeatherForADay);
		
		assertEquals(theTestAgainstWeatherManager.getTheSortedWeather(), theTestWeatherManager.getWeatherWithMatchedLocation("CARROLLTON, GA US"));
	}
	
	@Test
	public void shouldReturnMatchedArrayForManagerWithMultipleDaysMultipleMatches() {
		WeatherManager theTestWeatherManager = new WeatherManager();
		WeatherManager theTestAgainstWeatherManager = new WeatherManager();
		
		WeatherForADay firstWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-05", 92, 71);
		WeatherForADay secondWeatherForADay = new WeatherForADay("USC00091640", "DOUGLASVILLE, GA US", "2020-07-06", 80, 70);
		WeatherForADay thirdWeatherForADay = new WeatherForADay("USC00091640", "ATLANTA, GA US", "2020-07-07", 85, 65);
		WeatherForADay fourthWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-08", 90, 69);
		WeatherForADay fifthWeatherForADay = new WeatherForADay("USC00091640", "ATLANTA, GA US", "2020-07-09", 87, 68);
		WeatherForADay sixthWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-10", 89, 67);

		theTestWeatherManager.addWeatherDay(firstWeatherForADay);
		theTestWeatherManager.addWeatherDay(secondWeatherForADay);
		theTestWeatherManager.addWeatherDay(thirdWeatherForADay);
		theTestWeatherManager.addWeatherDay(fourthWeatherForADay);
		theTestWeatherManager.addWeatherDay(fifthWeatherForADay);
		theTestWeatherManager.addWeatherDay(sixthWeatherForADay);
		
		theTestAgainstWeatherManager.addWeatherDay(firstWeatherForADay);
		theTestAgainstWeatherManager.addWeatherDay(fourthWeatherForADay);
		theTestAgainstWeatherManager.addWeatherDay(sixthWeatherForADay);
		
		assertEquals(theTestAgainstWeatherManager.getTheSortedWeather(), theTestWeatherManager.getWeatherWithMatchedLocation("CARROLLTON, GA US"));
	}
	
	@Test
	public void shouldReturnMatchedArrayForLowerCaseLocation() {
		WeatherManager theTestWeatherManager = new WeatherManager();
		WeatherManager theTestAgainstWeatherManager = new WeatherManager();
		
		WeatherForADay firstWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-05", 92, 71);
		WeatherForADay secondWeatherForADay = new WeatherForADay("USC00091640", "DOUGLASVILLE, GA US", "2020-07-06", 80, 70);
		WeatherForADay thirdWeatherForADay = new WeatherForADay("USC00091640", "ATLANTA, GA US", "2020-07-07", 85, 65);

		theTestWeatherManager.addWeatherDay(firstWeatherForADay);
		theTestWeatherManager.addWeatherDay(secondWeatherForADay);
		theTestWeatherManager.addWeatherDay(thirdWeatherForADay);
		
		theTestAgainstWeatherManager.addWeatherDay(firstWeatherForADay);
		
		assertEquals(theTestAgainstWeatherManager.getTheSortedWeather(), theTestWeatherManager.getWeatherWithMatchedLocation("carrollton, ga us"));
	}
	
	@Test
	public void shouldReturnMatchedArrayForMultipleCaseLocation() {
		WeatherManager theTestWeatherManager = new WeatherManager();
		WeatherManager theTestAgainstWeatherManager = new WeatherManager();
		
		WeatherForADay firstWeatherForADay = new WeatherForADay("USC00091640", "CARROLLTON, GA US", "2020-07-05", 92, 71);
		WeatherForADay secondWeatherForADay = new WeatherForADay("USC00091640", "DOUGLASVILLE, GA US", "2020-07-06", 80, 70);
		WeatherForADay thirdWeatherForADay = new WeatherForADay("USC00091640", "ATLANTA, GA US", "2020-07-07", 85, 65);

		theTestWeatherManager.addWeatherDay(firstWeatherForADay);
		theTestWeatherManager.addWeatherDay(secondWeatherForADay);
		theTestWeatherManager.addWeatherDay(thirdWeatherForADay);
		
		theTestAgainstWeatherManager.addWeatherDay(firstWeatherForADay);
		
		assertEquals(theTestAgainstWeatherManager.getTheSortedWeather(), theTestWeatherManager.getWeatherWithMatchedLocation("Carrollton, Ga US"));
	}
	
}
