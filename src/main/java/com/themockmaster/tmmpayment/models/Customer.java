package com.themockmaster.tmmpayment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Customer {
	

	 @JsonProperty
	 private String email = null;
	 
	 @Override
	public String toString() {
		return "Customer [email=" + email + ", phonenumber=" + phonenumber + ", name=" + name + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
     private String phonenumber = null;
	 
	 @JsonProperty
     private String name = null;
 

}
