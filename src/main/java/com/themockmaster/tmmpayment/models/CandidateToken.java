package com.themockmaster.tmmpayment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Candidate_tokens")
public class CandidateToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_token_id")
	private Integer candidate_token_id;
	
	
	@Column(name = "token")
	private String token;
	
	@Override
	public String toString() {
		return "CandidateToken [candidate_token_id=" + candidate_token_id + ", token=" + token + ", email=" + email
				+ ", date_created=" + date_created + "]";
	}

	public Integer getCandidate_token_id() {
		return candidate_token_id;
	}

	public void setCandidate_token_id(Integer candidate_token_id) {
		this.candidate_token_id = candidate_token_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	@Column(name = "email")
	private String email;
	
	@Column(name = "date_created")
	private String date_created;
	

}
