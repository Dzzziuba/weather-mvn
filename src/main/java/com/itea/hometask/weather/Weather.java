package com.itea.hometask.weather;

public class Weather {
	// region variable
	private String city;
	private String region;
	private String country;
	private String condition;
	private String temp;
	private String chill;
	private String humidity;

	// endregion variable
	public Weather() {
	}

	// region getters&setters
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getChill() {
		return chill;
	}

	public void setChill(String chill) {
		this.chill = chill;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	// endregion getters&setters
	@Override
	public String toString() {
		return "--Country: " + getCountry() + "--" + "\n" + "--Region: " + getRegion() + "--" + "\n" + "--City: "
				+ getCity() + "--" + "\n" + "--Temp: " + getTemp() + "F--" + "\n" + "--Chill: " + getChill() + "mp/h--"
				+ "\n" + "--Text: " + getCondition() + "--" + "\n" + "--Humidity:" + getHumidity() + "%--";
	}
}