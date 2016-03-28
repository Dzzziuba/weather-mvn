package com.itea.hometask.weather;

public class PrintWeather {

	Weather weather;

	public PrintWeather(Weather weather) {
		this.weather = weather;
	}

	public String format(Weather weather) throws Exception {

		return weather.toString();
	}

}