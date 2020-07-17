package edu.westga.cs1302.weather.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.model.WeatherForADay;

class TestWeatherForADayConstructor {

	@Test
	public void shouldNotAllowNullStation() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay(null, "NEWNAN GA US", "2020-07-01", 92, 68);
		});
	}
	
	@Test
	public void shouldNotAllowEmptyStation() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("", "NEWNAN GA US", "2020-07-01", 92, 68);
		});
	}
	
	@Test
	public void shouldNotAllowNullLocation() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", null, "2020-07-01", 92, 68);
		});
	}
	
	@Test
	public void shouldNotAllowEmptyLocation() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", "", "2020-07-01", 92, 68);
		});
	}
	
	@Test
	public void shouldNotAllowNullDate() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", "CARROLLTON GA US", null, 92, 68);
		});
	}
	
	@Test
	public void shouldNotAllowEmptyDate() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", "CARROLLTON GA US", "", 92, 68);
		});
	}

}
