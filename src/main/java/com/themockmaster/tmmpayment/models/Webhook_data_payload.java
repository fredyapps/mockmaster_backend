package com.themockmaster.tmmpayment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Webhook_data_payload {
	
	@JsonProperty
	private Long id = null;
	
	@JsonProperty
	private String tx_ref = null;
	
	@JsonProperty
	private String flw_ref = null;
	
	@JsonProperty
	private String device_fingerprint = null;
	
	@JsonProperty
	private Long amount = null;
	
	@Override
	public String toString() {
		return "Webhook_data_payload [id=" + id + ", tx_ref=" + tx_ref + ", flw_ref=" + flw_ref
				+ ", device_fingerprint=" + device_fingerprint + ", amount=" + amount + ", currency=" + currency
				+ ", charged_amount=" + charged_amount + ", app_fee=" + app_fee + ", merchant_fee=" + merchant_fee
				+ ", processor_response=" + processor_response + ", auth_model=" + auth_model + ", ip=" + ip
				+ ", narration=" + narration + ", status=" + status + ", payment_type=" + payment_type + ", created_at="
				+ created_at + ", account_id=" + account_id + ", customer=" + customer + ", card=" + card + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTx_ref() {
		return tx_ref;
	}

	public void setTx_ref(String tx_ref) {
		this.tx_ref = tx_ref;
	}

	public String getFlw_ref() {
		return flw_ref;
	}

	public void setFlw_ref(String flw_ref) {
		this.flw_ref = flw_ref;
	}

	public String getDevice_fingerprint() {
		return device_fingerprint;
	}

	public void setDevice_fingerprint(String device_fingerprint) {
		this.device_fingerprint = device_fingerprint;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getCharged_amount() {
		return charged_amount;
	}

	public void setCharged_amount(Long charged_amount) {
		this.charged_amount = charged_amount;
	}

	public Double getApp_fee() {
		return app_fee;
	}

	public void setApp_fee(Double app_fee) {
		this.app_fee = app_fee;
	}

	public Long getMerchant_fee() {
		return merchant_fee;
	}

	public void setMerchant_fee(Long merchant_fee) {
		this.merchant_fee = merchant_fee;
	}

	public String getProcessor_response() {
		return processor_response;
	}

	public void setProcessor_response(String processor_response) {
		this.processor_response = processor_response;
	}

	public String getAuth_model() {
		return auth_model;
	}

	public void setAuth_model(String auth_model) {
		this.auth_model = auth_model;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public Webhook_customer_payload getCustomer() {
		return customer;
	}

	public void setCustomer(Webhook_customer_payload customer) {
		this.customer = customer;
	}

	public Webhook_card_payload getCard() {
		return card;
	}

	public void setCard(Webhook_card_payload card) {
		this.card = card;
	}

	@JsonProperty
	private String currency = null;
	
	@JsonProperty
	private Long charged_amount = null;
	
	@JsonProperty
	private Double app_fee = null;
	
	@JsonProperty
	private Long merchant_fee = null;
	
	@JsonProperty
	private String processor_response = null;
	
	@JsonProperty
	private String auth_model = null;
	
	@JsonProperty
	private String ip = null;
	
	@JsonProperty
	private String narration = null;
	
	@JsonProperty
	private String status = null;
	
	@JsonProperty
	private String payment_type = null;
	
	@JsonProperty
	private String created_at = null;
	
	@JsonProperty
	private Long account_id = null;
	
	@JsonProperty
	private Webhook_customer_payload customer = null;
	
	@JsonProperty
	private Webhook_card_payload card = null;
	
	

}


