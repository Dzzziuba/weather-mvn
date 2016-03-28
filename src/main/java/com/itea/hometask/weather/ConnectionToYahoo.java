package com.itea.hometask.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionToYahoo {

	public InputStream retrieve(String zipcode) throws Exception {

		String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20woeid%3D%22"
				+ zipcode + "%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		URLConnection conn = new URL(url).openConnection();
		return conn.getInputStream();
	}
}