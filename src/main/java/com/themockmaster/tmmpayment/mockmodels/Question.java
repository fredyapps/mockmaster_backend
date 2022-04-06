package com.themockmaster.tmmpayment.mockmodels;

import java.util.List;

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
@Table(name = "question")
public class Question {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "question_id")
	private Integer question_id;
	
	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question_text=" + question_text + ", question_answer="
				+ question_answer + ", admin_id=" + admin_id + ", domain_id=" + domain_id + ", candidateAnswer="
				+ candidateAnswer + ", options=" + options + "]";
	}



	public Integer getQuestion_id() {
		return question_id;
	}



	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}



	public String getQuestion_text() {
		return question_text;
	}



	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}



	public String getQuestion_answer() {
		return question_answer;
	}



	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}



	public Integer getAdmin_id() {
		return admin_id;
	}



	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}



	public String getDomain_id() {
		return domain_id;
	}



	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}



	public String getCandidateAnswer() {
		return candidateAnswer;
	}



	public void setCandidateAnswer(String candidateAnswer) {
		this.candidateAnswer = candidateAnswer;
	}



	public List<Option> getOptions() {
		return options;
	}



	public void setOptions(List<Option> options) {
		this.options = options;
	}



	@Column(name = "question_text")
	private String question_text;
	
	@Column(name = "question_answer")
	private String question_answer;
	
	@Column(name = "admin_id")
	private Integer admin_id;
	
	@Column(name = "domain_id")
	private String domain_id;
	
	@JsonInclude
	@Transient
	private transient String candidateAnswer;
	
	@JsonInclude
	@Transient
	private transient List<Option> options;

	

	public Question() {
	
	}

	




	
	
	

}
