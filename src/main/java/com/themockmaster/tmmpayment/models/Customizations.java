package com.themockmaster.tmmpayment.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Customizations {

	
   @JsonProperty
   private String title = null;
   
   @Override
public String toString() {
	return "Customizations [title=" + title + ", description=" + description + ", logo=" + logo + "]";
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getLogo() {
	return logo;
}

public void setLogo(String logo) {
	this.logo = logo;
}

@JsonProperty
   private String description = null;
   
   @JsonProperty
   private String logo = null;
   
   
}
