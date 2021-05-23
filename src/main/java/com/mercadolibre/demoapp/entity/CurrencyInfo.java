package com.mercadolibre.demoapp.entity;

public class CurrencyInfo {
	private long timestamp;
	private String source;
	private String date;
	private Rates rates;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long value) {
		this.timestamp = value;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String value) {
		this.source = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String value) {
		this.date = value;
	}

	public Rates getRates() {
		return rates;
	}

	public void setRates(Rates value) {
		this.rates = value;
	}

	@Override
	public String toString() {
		return "CurrencyInfo [timestamp=" + timestamp + ", source=" + source + ", date=" + date + ", rates=" + rates
				+ "]";
	}
	
	
}
