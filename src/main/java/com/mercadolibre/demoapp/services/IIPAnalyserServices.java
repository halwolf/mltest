package com.mercadolibre.demoapp.services;

import org.springframework.http.ResponseEntity;

import com.mercadolibre.demoapp.exceptions.GeneralException;

public interface IIPAnalyserServices  {

	
	public ResponseEntity getDataByIP(String ip) throws GeneralException;
	
	public ResponseEntity banIp(String ip) throws GeneralException;
	
}
