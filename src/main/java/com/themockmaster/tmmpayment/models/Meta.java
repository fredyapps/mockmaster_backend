package com.themockmaster.tmmpayment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Meta {

	   @JsonProperty
	   private int consumer_id ;
	   
	   @Override
	public String toString() {
		return "Meta [consumer_id=" + consumer_id + ", consumer_mac=" + consumer_mac + "]";
	}

	public int getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(int consumer_id) {
		this.consumer_id = consumer_id;
	}

	public String getConsumer_mac() {
		return consumer_mac;
	}

	public void setConsumer_mac(String consumer_mac) {
		this.consumer_mac = consumer_mac;
	}

	@JsonProperty
       private String consumer_mac = null;
       

}
