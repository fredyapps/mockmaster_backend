package com.themockmaster.tmmpayment.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tmmpayment")
public class Transaction {
	
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_table;
	
	@Column(name = "transaction_id")
	private Long transaction_id;

	@Column(name = "reference")
	private String reference;
	
	@JsonProperty
	@Column(name = "amount")
	private String amount;
	
	@JsonProperty
	@Column(name = "currency")
	private String currency;
	
	@JsonProperty
	@Column(name = "email")
	private String email;
	































	@Override
	public String toString() {
		return "Transaction [id_table=" + id_table + ", transaction_id=" + transaction_id + ", reference=" + reference
				+ ", amount=" + amount + ", currency=" + currency + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", name=" + name + ", description=" + description + ", operator_message=" + operator_message
				+ ", offer=" + offer + ", attempts=" + attempts + ", completed=" + completed + ", created_at="
				+ created_at + ", updated_at=" + updated_at + "]";
	}




	public Transaction(Long id_table, Long transaction_id, String reference, String amount, String currency,
			String email, String phonenumber, String name, String description, String operator_message, Integer offer,
			Integer attempts, String completed, String created_at, String updated_at) {
		super();
		this.id_table = id_table;
		this.transaction_id = transaction_id;
		this.reference = reference;
		this.amount = amount;
		this.currency = currency;
		this.email = email;
		this.phonenumber = phonenumber;
		this.name = name;
		this.description = description;
		this.operator_message = operator_message;
		this.offer = offer;
		this.attempts = attempts;
		this.completed = completed;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}




	public Integer getOffer() {
		return offer;
	}




	public void setOffer(Integer offer) {
		this.offer = offer;
	}




	public Long getTransaction_id() {
		return transaction_id;
	}




	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}




	public String getCompleted() {
		return completed;
	}




	public Transaction() {
		
		
	}




	public Long getId_table() {
		return id_table;
	}

	public void setId_table(Long id_table) {
		this.id_table = id_table;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String published) {
		this.description = published;
	}

	public String isCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}






	public String getOperator_message() {
		return operator_message;
	}


	public void setOperator_message(String operator_message) {
		this.operator_message = operator_message;
	}






	@JsonProperty
	@Column(name = "phonenumber")
	private String phonenumber;
	
	@JsonProperty
	@Column(name = "name")
	private String name;
	
	@JsonProperty
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@JsonProperty
	@Column(name = "operator_message")
	private String operator_message;
	
	
	@JsonIgnore
	@Column(name = "offer")
	private Integer offer;
	
	
	@Column(name = "attempts")
	private Integer attempts;
	





	




	public Integer getAttempts() {
		return attempts;
	}




	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}






	@JsonIgnore
	@Column(name = "completed")
	private String completed="No";
	
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "created_at")
	private String created_at;
	
	@JsonIgnore
	@Column(name = "updated_at")
	private String updated_at;
	

	

}
