package com.themockmaster.tmmpayment.paystackmodels;



public class Authorization {

	
	public String getAuthorization_code() {
		return authorization_code;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
	public String getBin() {
		return bin;
	}
	@Override
	public String toString() {
		return "Authorization [authorization_code=" + authorization_code + ", bin=" + bin + ", last4=" + last4
				+ ", exp_month=" + exp_month + ", exp_year=" + exp_year + ", channel=" + channel + ", card_type="
				+ card_type + ", bank=" + bank + ", country_code=" + country_code + ", brand=" + brand + ", reusable="
				+ reusable + ", signature=" + signature + ", account_name=" + account_name + "]";
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	public String getLast4() {
		return last4;
	}
	public void setLast4(String last4) {
		this.last4 = last4;
	}
	public String getExp_month() {
		return exp_month;
	}
	public void setExp_month(String exp_month) {
		this.exp_month = exp_month;
	}
	public String getExp_year() {
		return exp_year;
	}
	public void setExp_year(String exp_year) {
		this.exp_year = exp_year;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean isReusable() {
		return reusable;
	}
	public void setReusable(boolean reusable) {
		this.reusable = reusable;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	private String authorization_code;
	private String bin;
	private String last4;
	private String exp_month;
	private String exp_year;
	private String channel;
	private String card_type;
	private String bank;
	private String country_code;
	private String brand;
	private boolean reusable;
	private String signature;
	private String account_name;
}
