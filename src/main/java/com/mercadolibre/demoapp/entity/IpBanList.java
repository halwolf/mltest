package com.mercadolibre.demoapp.entity;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "ip_ban_list")
@JsonPropertyOrder({ "id", "ip", "createdAt" })
@Configuration
@EnableMongoAuditing
public class IpBanList {

	@Id
	private String id;
	private String ip;
	@DateTimeFormat(style = "M-")
	@CreatedDate
	private Date createdAt;

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getIp() {
		return ip;
	}

	public final void setIp(String ip) {
		this.ip = ip;
	}

	public final Date getCreatedAt() {
		return createdAt;
	}

	public final void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
