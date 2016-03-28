package com.itea.hometask.weather;

import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws Exception {

		String zipcode = "924938";
		try {
			zipcode = args[0];
		} catch (Exception e) {
		}

		// Start the program
		new Main(zipcode).start();
	}

	private String zip;

	public Main(String zip) {
		this.zip = zip;
	}

	public void start() throws Exception {
		// Retrieve Data
		InputStream dataIn = new ConnectionToYahoo().retrieve(zip);

		// Parse Data
		Weather weather = new ReadingXML().parse(dataIn);

		// Format (Print) Data
		System.out.print(new PrintWeather(weather).format(weather));
	}
}