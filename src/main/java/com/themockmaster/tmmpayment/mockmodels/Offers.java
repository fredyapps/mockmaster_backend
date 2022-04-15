package com.themockmaster.tmmpayment.mockmodels;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "packages")
public class Offers {
	
	
	public Offers() {}
	
	

	public Integer getAttempts() {
		return attempts;
	}






	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}






	public Offers(Integer package_id, String name, String exam, Integer ghc_price, Integer attempts,
		List<OffersItems> items) {
	super();
	this.package_id = package_id;
	this.name = name;
	this.exam = exam;
	this.ghc_price = ghc_price;
	this.attempts = attempts;
	this.items = items;
}



	public Integer getPackage_id() {
		return package_id;
	}



	public void setPackage_id(Integer package_id) {
		this.package_id = package_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getExam() {
		return exam;
	}



	public void setExam(String exam) {
		this.exam = exam;
	}



	public Integer getGhc_price() {
		return ghc_price;
	}



	public void setGhc_price(Integer ghc_price) {
		this.ghc_price = ghc_price;
	}



	public List<OffersItems> getItems() {
		return items;
	}



	public void setItems(List<OffersItems> items) {
		this.items = items;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "package_id")
	private Integer package_id;
	

	@Column(name = "name")
	private String name;
	
	@Column(name = "exam")
	private String exam;
	
	@Column(name = "ghc_price")
	private Integer ghc_price;
	
	@Column(name = "attempts")
	private Integer attempts;
	
	@JsonInclude
	@Transient
	private transient List<OffersItems> items;

}
