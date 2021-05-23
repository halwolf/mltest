package com.mercadolibre.demoapp.response;

import com.fasterxml.jackson.annotation.*;
import com.mercadolibre.demoapp.entity.IpRegisterLog;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"success", "message","result"})
public class Response {

	private boolean success;
	private String message;
	private IpRegisterLog result;

	public Response() {

	}
	
	public Response(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public Response( String message) {
		this.success = Boolean.TRUE;
		this.message = message;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean value) {
		this.success = value;
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}

	public final IpRegisterLog getResult() {
		return result;
	}

	public final void setResult(IpRegisterLog result) {
		this.result = result;
	}

}
