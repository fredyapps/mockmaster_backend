package com.themockmaster.tmmpayment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Webhook_main_payload {
	
	@JsonProperty
	private String event = null;
	
	@JsonProperty
	private Webhook_data_payload data;

	@Override
	public String toString() {
		return "Webhook_main_payload [event=" + event + ", data=" + data + "]";
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Webhook_data_payload getData() {
		return data;
	}

	public void setData(Webhook_data_payload data) {
		this.data = data;
	}
	

}
