package com.mercadolibre.demoapp.entity;

import java.util.List;

public class CountryInfo {
	private List<Currency> currencies;
	private String name;

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> value) {
		this.currencies = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	@Override
	public String toString() {
		return "CountryInfo [currencies=" + currencies + ", name=" + name + "]";
	}
	
}
