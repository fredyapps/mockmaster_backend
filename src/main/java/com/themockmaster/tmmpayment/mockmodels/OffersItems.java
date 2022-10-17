package com.themockmaster.tmmpayment.mockmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "package_items")
public class OffersItems {
	
	
	@Override
	public String toString() {
		return "OffersItems [item_id=" + item_id + ", name=" + name + ", package_id=" + package_id + "]";
	}

	public OffersItems() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Integer item_id;
	

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPackage_id() {
		return package_id;
	}

	public void setPackage_id(Integer package_id) {
		this.package_id = package_id;
	}

	@Column(name = "name")
	private String name;
	
	@Column(name = "package_id")
	private Integer package_id;


}
