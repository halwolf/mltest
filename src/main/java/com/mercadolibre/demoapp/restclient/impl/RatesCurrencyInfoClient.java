package com.mercadolibre.demoapp.restclient.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mercadolibre.demoapp.entity.CurrencyInfo;

@Service
public class RatesCurrencyInfoClient {

	public static final String GET_DATA = "https://v1.nocodeapi.com/jotamartinez1995/currency/rates?api_key=T1H0TJrg6FhaCuhtUyIzKEulTbRDoQwX&source=%s&target=USD,EUR";
	static RestTemplate restTemplate = new RestTemplate();

	// TODO: Ajustar implementacion
	public CurrencyInfo getConvertCurrencyBySource(String sourceCurrency) {
		String url = String.format(GET_DATA, sourceCurrency);
		return restTemplate.getForObject(url, CurrencyInfo.class);
	}
}
