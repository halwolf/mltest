package com.mercadolibre.demoapp.entity;


public class Currency {
	private String code;
	private String name;
	private String symbol;

	public String getCode() {
		return code;
	}

	public void setCode(String value) {
		this.code = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String value) {
		this.symbol = value;
	}

	@Override
	public String toString() {
		return "Currency [code=" + code + ", name=" + name + ", symbol=" + symbol + "]";
	}
	
	
}
