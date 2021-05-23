package com.mercadolibre.demoapp.restclient.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mercadolibre.demoapp.entity.CountryInfo;

@Service
public class CountriesInfoClient {

	

	public static final String GET_DATA = "https://restcountries.eu/rest/v2/alpha/%s?fields=name;currencies";
	static RestTemplate restTemplate = new RestTemplate();

	public CountryInfo getGeoLocDataByIP(String countryCode) {
		
		String url = String.format(GET_DATA,countryCode);
		return restTemplate.getForObject(url, CountryInfo.class);
		
	}
	
}
