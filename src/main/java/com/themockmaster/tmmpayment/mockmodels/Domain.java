package com.themockmaster.tmmpayment.mockmodels;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "domain")
public class Domain {
	
	
	public Domain() {}
	
	

	public Domain(String domain_id, String domain_text, Integer domain_total_question, Double domain_score_per_question,
			String exam_code) {
		super();
		this.domain_id = domain_id;
		this.domain_text = domain_text;
		this.domain_total_question = domain_total_question;
		this.domain_score_per_question = domain_score_per_question;
		this.exam_code = exam_code;
	}



	@Override
	public String toString() {
		return "Domain [domain_id=" + domain_id + ", domain_text=" + domain_text + ", domain_total_question="
				+ domain_total_question + ", domain_score_per_question=" + domain_score_per_question + ", exam_code="
				+ exam_code + "]";
	}



	public String getDomain_id() {
		return domain_id;
	}

	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}

	public String getDomain_text() {
		return domain_text;
	}

	public void setDomain_text(String domain_text) {
		this.domain_text = domain_text;
	}

	public Integer getDomain_total_question() {
		return domain_total_question;
	}

	public void setDomain_total_question(Integer domain_total_question) {
		this.domain_total_question = domain_total_question;
	}

	public Double getDomain_score_per_question() {
		return domain_score_per_question;
	}

	public void setDomain_score_per_question(Double domain_score_per_question) {
		this.domain_score_per_question = domain_score_per_question;
	}

	public String getExam_code() {
		return exam_code;
	}

	public void setExam_code(String exam_code) {
		this.exam_code = exam_code;
	}



	@Id
	@Column(name = "domain_id")
	private String domain_id;
	

	@Column(name = "domain_text")
	private String domain_text;
	
	

	@Column(name = "domain_total_question")
	private Integer domain_total_question;
	
	@Column(name = "domain_score_per_question")
	private Double domain_score_per_question;
	
	@Column(name = "exam_code")
	private String exam_code;
	
	

}
