package com.mercadolibre.demoapp.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mercadolibre.demoapp.entity.IpRegisterLog;
import com.mercadolibre.demoapp.entity.Rates;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

	private String ipOrigen;
	private String countryCode;
	private String countryName;
	private String currency;
	private Rates rates;

	public Result() {

	}
	
	public Result(IpRegisterLog registerLog) {
		this.countryCode = registerLog.getCountryCode();
		this.countryName = registerLog.getCountryName();
		this.currency = registerLog.getCurrency();
		this.rates = registerLog.getRates();
	}
	
	
	public Result(String ipOrigen, String countryCode, String countryName, String currency, Rates rates) {
		this.ipOrigen = ipOrigen;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.currency = currency;
		this.rates = rates;
	}

	public final String getIpOrigen() {
		return ipOrigen;
	}

	public final void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	public final String getCountryCode() {
		return countryCode;
	}

	public final void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public final String getCountryName() {
		return countryName;
	}

	public final void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public final String getCurrency() {
		return currency;
	}

	public final void setCurrency(String currency) {
		this.currency = currency;
	}

	public final Rates getRates() {
		return rates;
	}

	public final void setRates(Rates rates) {
		this.rates = rates;
	}

}
