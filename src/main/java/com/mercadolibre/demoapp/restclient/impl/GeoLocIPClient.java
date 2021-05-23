package com.mercadolibre.demoapp.restclient.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mercadolibre.demoapp.entity.GeoLocIP;

@Service
public class GeoLocIPClient {

	public static final String GET_DATA = "http://api.ipapi.com/%s?access_key=b1156aae7bfcb13f96f08e2931967792&fields=country_code,country_name";
	static RestTemplate restTemplate = new RestTemplate();

	// TODO: Ajustar implementacion
	public GeoLocIP getGeoLocDataByIP(String ip) {
		String url = String.format(GET_DATA, ip);
		return restTemplate.getForObject(url, GeoLocIP.class);
	}

}
