package com.themockmaster.tmmpayment.paystackmodels;

public class WebhookRes {

	
	private String event;
	private Data_2 data;
	
	
	
	@Override
	public String toString() {
		return "WebhookRes [event=" + event + ", data=" + data + "]";
	}
	
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Data_2 getData() {
		return data;
	}
	public void setData(Data_2 data) {
		this.data = data;
	}
	
	
}
