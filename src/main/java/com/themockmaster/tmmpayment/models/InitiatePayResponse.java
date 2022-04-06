package com.themockmaster.tmmpayment.models;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor 
public class InitiatePayResponse {
	
	
	@JsonProperty
	private String status = null;
	
	@JsonProperty
	private String message = null;
	

	@Override
	public String toString() {
		return "InitiatePayResponse [status=" + status + ", message=" + message + ", data=" + data + "]";
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public HashMap<String, String> getData() {
		return data;
	}


	public void setData(HashMap<String, String> data) {
		this.data = data;
	}


	private HashMap<String,String> data = null;
	


}
