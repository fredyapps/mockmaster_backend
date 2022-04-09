package com.themockmaster.tmmpayment.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name = "candidates")
public class Candidate  implements Serializable{
	
	
	public Candidate() {}
	
	@Override
	public String toString() {
		return "Candidate [candidate_id=" + candidate_id + ", email=" + email + ", phone_number=" + phone_number
				+ ", password=" + password + ", profession=" + profession + ", token=" + token + ", role=" + role
				+ ", date_created=" + date_created + ", date_updated=" + date_updated + "]";
	}

	public Integer getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_id")
	private Integer candidate_id;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	@Transient
	@Column(name = "password")
	private  String password;
	
	@Column(name = "profession")
	private String profession;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "role")
	private String role;
	
	@JsonIgnore
	@Column(name = "date_created")
	private String date_created;
	
	@JsonIgnore
	@Column(name = "date_updated")
	private String date_updated;
	
	

}
