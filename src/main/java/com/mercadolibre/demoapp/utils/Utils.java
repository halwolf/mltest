package com.mercadolibre.demoapp.utils;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mercadolibre.demoapp.exceptions.GeneralException;
import com.mercadolibre.demoapp.response.Response;

public class Utils {

	public static boolean inNull(Object o) {
		return o == null;
	}

	public static boolean inNullOrEmpty(String s) {
		return s == null || s.equals("");
	}

	public static boolean isNullOrEmpty(Collection<?> list) {
		return list == null || list.isEmpty();
	}

	public static Date getDateSubstract(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return calendar.getTime();
	}

	public static boolean isIP(String ip) {
		Pattern p = Pattern.compile(Constants.IP_REGEX);
		Matcher m = p.matcher(ip);
		return m.matches();
	}

	public static ResponseEntity createResponse(GeneralException ex) {
		Response r = new Response(Boolean.FALSE, ex.getMessage());	
		return new ResponseEntity(r, ex.getStatus());
	}

	public static ResponseEntity createResponse(Exception ex) {
		String message = String.format(Constants.INTERNAL_ERROR, ex.getMessage());
		Response r = new Response(Boolean.FALSE, message);
		return new ResponseEntity(r, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity createResponse(Response r) {
		return new ResponseEntity(r, HttpStatus.OK);
	}
	
	public static ResponseEntity createResponse(String message) {
		Response r = new Response(message);
		return new ResponseEntity(r, HttpStatus.ACCEPTED);
	}

}
