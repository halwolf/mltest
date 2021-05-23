package com.mercadolibre.demoapp.entity;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "ip_register_log")
@JsonPropertyOrder({ "id", "ipOrigen", "countryCode", "countryName", "currency", "rates", "createdAt" })
@Configuration
@EnableMongoAuditing
public class IpRegisterLog {

	@Id
	private String id;
	private String ipOrigen;
	private String countryCode;
	private String countryName;
	private String currency;
	private Rates rates;
	@CreatedDate
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdAt;

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getIpOrigen() {
		return ipOrigen;
	}

	public final void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	public final Date getCreatedAt() {
		return createdAt;
	}

	public final void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
