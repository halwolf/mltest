package com.mercadolibre.demoapp.utils;

public class Constants {

	private Constants() {
	}

	public static final String PATH = "/";
	public static final String METHOD_GET_DATA_BY_IP = "getDataByIp/{ip}";
	public static final String METHOD_POST_BAN_IP = "banIp/{ip}";
	
	public static final String SUCCESS_MESSAGE = "Exitoso";
	public static final String INTERNAL_ERROR = "Se ha presentado un error en la aplicacion: %s";
	
	public static final String IP_REGEX = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
	
	public static final String ALREADY_BLOCKED_IP = "Esta IP se encuentra baneada/listanegra: %s";
	public static final String BLOCKED_IP = "Se ha bloqueado la IP: %s";
	public static final String INVALID_FORMAT = "Formato de entrada invalido";
	public static final String REQUIRED_IP = "Dato obligatorio IP";
	public static final String IP_NOT_FOUND = "IP no encontrado en la API de localizacion: %s";
	
}
