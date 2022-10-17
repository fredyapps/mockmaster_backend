package com.themockmaster.tmmpayment.paystackmodels;

import com.fasterxml.jackson.annotation.JsonProperty;





public class InitiatePayReq {
	
	
	@Override
	public String toString() {
		return "InitiatePayReq [email=" + email + ", amount=" + amount + "]";
	}
	
	
	public InitiatePayReq() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@JsonProperty
	private String email;
	
	@JsonProperty
	private String amount;
	
	




	
	

}

