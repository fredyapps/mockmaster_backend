package com.themockmaster.tmmpayment.mockmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "exam_results")
public class ExamResult {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private Integer result_id;
	
	@Column(name = "exam_token")
	private String exam_token;
	
	@Column(name = "exam_id")
	private Integer exam_id;
	
	@Column(name = "domain_id")
	private String domain_id;
	
	@Column(name = "first_score")
	private String first_score;
	
	@Column(name = "second_score")
	private String second_score;
	
	@Column(name = "passed")
	private String passed;



	@Override
	public String toString() {
		return "ExamResult [result_id=" + result_id + ", exam_token=" + exam_token + ", exam_id=" + exam_id
				+ ", domain_id=" + domain_id + ", first_score=" + first_score + ", second_score=" + second_score
				+ ", passed=" + passed + "]";
	}

	public Integer getResult_id() {
		return result_id;
	}

	public void setResult_id(Integer result_id) {
		this.result_id = result_id;
	}

	public String getExam_token() {
		return exam_token;
	}

	public void setExam_token(String exam_token) {
		this.exam_token = exam_token;
	}

	public Integer getExam_id() {
		return exam_id;
	}

	public void setExam_id(Integer exam_id) {
		this.exam_id = exam_id;
	}

	public String getDomain_id() {
		return domain_id;
	}

	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}

	public String getFirst_score() {
		return first_score;
	}

	public void setFirst_score(String first_score) {
		this.first_score = first_score;
	}

	public String getSecond_score() {
		return second_score;
	}

	public void setSecond_score(String second_score) {
		this.second_score = second_score;
	}

	public String getPassed() {
		return passed;
	}

	public void setPassed(String passed) {
		this.passed = passed;
	}

	
	
	
	
	
}
