package com.themockmaster.tmmpayment.mockmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "option")
public class Option {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "option_id")
	private Long option_id;
	

	@Column(name = "option_code")
	private String option_code;
	
	@Column(name = "option_text")
	private String option_text;
	
	@Column(name = "question_id")
	private int question_id;
	
	@Override
	public String toString() {
		return "Option [option_id=" + option_id + ", option_code=" + option_code + ", option_text=" + option_text
				+ ", question_id=" + question_id + ", admin_id=" + admin_id + "]";
	}

	public Long getOption_id() {
		return option_id;
	}

	public void setOption_id(Long option_id) {
		this.option_id = option_id;
	}

	public String getOption_code() {
		return option_code;
	}

	public void setOption_code(String option_code) {
		this.option_code = option_code;
	}

	public String getOption_text() {
		return option_text;
	}

	public void setOption_text(String option_text) {
		this.option_text = option_text;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	@Column(name = "admin_id")
	private int admin_id;

}
