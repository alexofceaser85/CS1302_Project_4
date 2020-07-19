package edu.westga.cs1302.weather.io.testing;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.io.ReadWeatherFile;

class TestReadWeatherFile {

	@Test
	public void shouldNotSetNullFileName() {
		
		ReadWeatherFile theReadWeatherFile = new ReadWeatherFile();
		
		assertThrows(IllegalArgumentException.class, () -> {
			theReadWeatherFile.setFileName(null);
		});
	}
	
	@Test
	public void shouldNotSetEmptyFileName() {
		
		ReadWeatherFile theReadWeatherFile = new ReadWeatherFile();
		
		assertThrows(IllegalArgumentException.class, () -> {
			theReadWeatherFile.setFileName("");
		});
	}

}
