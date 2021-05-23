package com.mercadolibre.demoapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoLocIP {
	private String countryCode;
	private String countryName;

	@JsonProperty("country_code")
	public String getCountryCode() {
		return countryCode;
	}

	@JsonProperty("country_code")
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	@JsonProperty("country_name")
	public String getCountryName() {
		return countryName;
	}

	@JsonProperty("country_name")
	public void setCountryName(String value) {
		this.countryName = value;
	}

	@Override
	public String toString() {
		return "GeoLocIP [countryCode=" + countryCode + ", countryName=" + countryName + "]";
	}

}
