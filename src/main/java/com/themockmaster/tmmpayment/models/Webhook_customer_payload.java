package com.themockmaster.tmmpayment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Webhook_customer_payload {
	
	@JsonProperty
	private Long id = null;
	
	@JsonProperty
	private String name = null;
	
	@JsonProperty
	private String phone_number = null;
	
	@Override
	public String toString() {
		return "Webhook_customer_payload [id=" + id + ", name=" + name + ", phone_number=" + phone_number + ", email="
				+ email + ", created_at=" + created_at + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	@JsonProperty
	private String email = null;
	
	@JsonProperty
	private String created_at = null;
	

}




