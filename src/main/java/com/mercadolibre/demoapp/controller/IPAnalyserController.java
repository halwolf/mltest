package com.mercadolibre.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.demoapp.exceptions.GeneralException;
import com.mercadolibre.demoapp.response.Response;
import com.mercadolibre.demoapp.services.IIPAnalyserServices;
import com.mercadolibre.demoapp.utils.Constants;

@RestController(Constants.PATH)
public class IPAnalyserController {

	@Autowired
	IIPAnalyserServices services;

	@GetMapping(Constants.METHOD_GET_DATA_BY_IP)
	public ResponseEntity<Response> getDataByIp(@PathVariable String ip) throws GeneralException {
		return services.getDataByIP(ip);
	}

	@PostMapping(Constants.METHOD_POST_BAN_IP)
	public ResponseEntity<Response> banIp(@PathVariable String ip) throws GeneralException {
		return services.banIp(ip);
	}

}
