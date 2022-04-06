package com.themockmaster.tmmpayment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InitiatePayRequest {
	
	
	@JsonProperty
	private String tx_ref = null;
	
	@JsonProperty
	private String amount = null;
	
	@JsonProperty
	private String currency = null;
	
	@JsonProperty
	private String redirect_url = null;
	
	@Override
	public String toString() {
		return "InitiatePayRequest [tx_ref=" + tx_ref + ", amount=" + amount + ", currency=" + currency
				+ ", redirect_url=" + redirect_url + ", payment_options=" + payment_options + ", meta=" + meta
				+ ", customer=" + customer + ", customizations=" + customizations + "]";
	}

	public String getTx_ref() {
		return tx_ref;
	}

	public void setTx_ref(String tx_ref) {
		this.tx_ref = tx_ref;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRedirect_url() {
		return redirect_url;
	}

	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}

	public String getPayment_options() {
		return payment_options;
	}

	public void setPayment_options(String payment_options) {
		this.payment_options = payment_options;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customizations getCustomizations() {
		return customizations;
	}

	public void setCustomizations(Customizations customizations) {
		this.customizations = customizations;
	}

	@JsonProperty
	private String payment_options = null;
	
	@JsonProperty
	private Meta meta = null;
	
	@JsonProperty
	private Customer customer = null;
	
	@JsonProperty
	private Customizations customizations = null;
	
	

}




