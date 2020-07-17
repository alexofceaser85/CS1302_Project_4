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
	
	@Test
	public void shouldNotAllowMinimumTemperatureWellAboveMaximumTemperature() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", "CARROLLTON GA US", "", 20, 140);
		});
	}
	
	@Test
	public void shouldNotAllowMinimumTemperatureOneAboveMaximumTemperature() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", "CARROLLTON GA US", "", 92, 93);
		});
	}
	
	@Test
	public void shouldNotAllowMinimumTemperatureOneTenthAboveMaximumTemperature() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", "CARROLLTON GA US", "", 92, 92.1);
		});
	}
	
	@Test
	public void shouldNotAllowMinimumTemperatureOneHalfAboveMaximumTemperature() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", "CARROLLTON GA US", "", 92, 92.5);
		});
	}
	
	@Test
	public void shouldNotAllowMinimumTemperatureNineTenthsAboveMaximumTemperature() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new WeatherForADay("USC00091640", "CARROLLTON GA US", "", 92, 92.9);
		});
	}
	
	@Test
	public void shouldAllowStationUpperCase() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-07-01", 92, 68); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: CARROLLTON GA US taken on: 2020-07-01 with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", testWeather.toString());
	}
	
	@Test
	public void shouldAllowStationAllLowerCase() {
		
		WeatherForADay testWeather = new WeatherForADay("usc00091640", "CARROLLTON GA US", "2020-07-01", 92, 68); 
		
		assertEquals("The day: 2020-07-01 at the station: usc00091640 at the location: CARROLLTON GA US taken on: 2020-07-01 with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", testWeather.toString());
	}
	
	@Test
	public void shouldAllowStationMultipleCase() {
		
		WeatherForADay testWeather = new WeatherForADay("uSC00091640", "CARROLLTON GA US", "2020-07-01", 92, 68); 
		
		assertEquals("The day: 2020-07-01 at the station: uSC00091640 at the location: CARROLLTON GA US taken on: 2020-07-01 with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", testWeather.toString());
	}
	
	@Test
	public void shouldAllowLocationUpperCase() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "CARROLLTON GA US", "2020-07-01", 92, 68); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: CARROLLTON GA US taken on: 2020-07-01 with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", testWeather.toString());
	}
	
	@Test
	public void shouldAllowLocationLowerCase() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "carrollton ga us", "2020-07-01", 92, 68); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: carrollton ga us taken on: 2020-07-01 with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", testWeather.toString());
	}
	
	@Test
	public void shouldAllowLocationMultipleCase() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", 92, 68); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 92.0 with the minimum temperature of: 68.0", testWeather.toString());
	}
	
	@Test
	public void shouldAllowMaximumTemperatureWellAboveZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", 200, 68); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 200.0 with the minimum temperature of: 68.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMaximumTemperatureOneAboveZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", 1, 0); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 1.0 with the minimum temperature of: 0.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMaximumTemperatureOneTenthAboveZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", .1, 0); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 0.1 with the minimum temperature of: 0.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMaximumTemperatureAtZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", 0, -200); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 0.0 with the minimum temperature of: -200.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMaximumTemperatureWellBelowZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", -200, -201); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: -200.0 with the minimum temperature of: -201.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMaximumTemperatureOneBelowZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", -1, -200); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: -1.0 with the minimum temperature of: -200.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMaximumTemperatureOneTenthBelowZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", -.1, -200); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: -0.1 with the minimum temperature of: -200.0", testWeather.toString());
		
	}
	
	
	
	@Test
	public void shouldAllowMinimumTemperatureWellAboveZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", 250, 200); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 250.0 with the minimum temperature of: 200.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMinimumTemperatureOneAboveZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", 1, 0); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 1.0 with the minimum temperature of: 0.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMinimumTemperatureOneTenthAboveZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", .1, 0); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 0.1 with the minimum temperature of: 0.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMinimumTemperatureAtZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", 1, 0); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 1.0 with the minimum temperature of: 0.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMinimumTemperatureWellBelowZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", -200, -250); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: -200.0 with the minimum temperature of: -250.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMinimumTemperatureOneBelowZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", -200, -250); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: -200.0 with the minimum temperature of: -250.0", testWeather.toString());
		
	}
	
	@Test
	public void shouldAllowMinimumTemperatureOneTenthBelowZero() {
		
		WeatherForADay testWeather = new WeatherForADay("USC00091640", "Carrollton GA US", "2020-07-01", 0, -.1); 
		
		assertEquals("The day: 2020-07-01 at the station: USC00091640 at the location: Carrollton GA US taken on: 2020-07-01 with the maximum temperature of: 0.0 with the minimum temperature of: -0.1", testWeather.toString());
		
	}

}
