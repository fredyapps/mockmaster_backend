package com.themockmaster.tmmpayment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Webhook_card_payload {
	
	@JsonProperty
	private String first_6digits = null;
	
	@JsonProperty
	private String last_4digits = null;
	
	@JsonProperty
	private String issuer = null;
	
	@Override
	public String toString() {
		return "Webhook_card_payload [first_6digits=" + first_6digits + ", last_4digits=" + last_4digits + ", issuer="
				+ issuer + ", country=" + country + ", type=" + type + ", expiry=" + expiry + "]";
	}

	public String getFirst_6digits() {
		return first_6digits;
	}

	public void setFirst_6digits(String first_6digits) {
		this.first_6digits = first_6digits;
	}

	public String getLast_4digits() {
		return last_4digits;
	}

	public void setLast_4digits(String last_4digits) {
		this.last_4digits = last_4digits;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@JsonProperty
	private String country = null;
	
	@JsonProperty
	private String type = null;
	
	@JsonProperty
	private String expiry = null;
	
	

}


