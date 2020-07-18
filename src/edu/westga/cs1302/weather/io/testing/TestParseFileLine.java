package edu.westga.cs1302.weather.io.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.weather.io.ReadWeatherFile;

class TestParseFileLine {

	@Test
	public void test() {
		ReadWeatherFile read = new ReadWeatherFile();
		
		read.readFile();
	}

}
