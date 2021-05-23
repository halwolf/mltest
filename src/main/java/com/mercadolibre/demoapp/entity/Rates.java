package com.mercadolibre.demoapp.entity;

import com.fasterxml.jackson.annotation.*;

public class Rates {
	private double eur;
	private double usd;

	@JsonProperty("EUR")
	public double getEur() {
		return eur;
	}

	@JsonProperty("EUR")
	public void setEur(double value) {
		this.eur = value;
	}

	@JsonProperty("USD")
	public double getUsd() {
		return usd;
	}

	@JsonProperty("USD")
	public void setUsd(double value) {
		this.usd = value;
	}

	@Override
	public String toString() {
		return "Rates [eur=" + eur + ", usd=" + usd + "]";
	}
	
	
}
