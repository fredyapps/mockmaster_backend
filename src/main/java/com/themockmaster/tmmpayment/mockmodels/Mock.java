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
@Table(name = "mocks")
public class Mock {
	
	public Integer getMockId() {
		return mockId;
	}

	public void setMockId(Integer mockId) {
		this.mockId = mockId;
	}


	

	public String getStatus() {
		return status;
	}

	public void setStatus(String passed) {
		this.status = passed;
	}

	public String getExam_id() {
		return exam_id;
	}

	

	@Override
	public String toString() {
		return "Mock [mockId=" + mockId + ", exam_id=" + exam_id + ", candidate_id=" + candidate_id
				+ ", start_date_time=" + start_date_time + ", end_date_time=" + end_date_time + ", exam_token="
				+ exam_token + ", completed=" + completed + ", exam_score=" + exam_score + ", status=" + status + "]";
	}

	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}

	public String getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getStart_date_time() {
		return start_date_time;
	}

	public void setStart_date_time(String start_date_time) {
		this.start_date_time = start_date_time;
	}

	public String getEnd_date_time() {
		return end_date_time;
	}

	public void setEnd_date_time(String end_date_time) {
		this.end_date_time = end_date_time;
	}

	public String getExam_token() {
		return exam_token;
	}

	public void setExam_token(String exam_token) {
		this.exam_token = exam_token;
	}

	public String getExam_score() {
		return exam_score;
	}

	public void setExam_score(String exam_score) {
		this.exam_score = exam_score;
	}

	public List<ExamResult> getExamResult() {
		return examResult;
	}

	public void setExamResult(List<ExamResult> examResult) {
		this.examResult = examResult;
	}

	

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mock_id")
	private Integer mockId;
	
	
	@Column(name = "exam_id")
	private String exam_id;
	
	@Column(name = "candidate_id")
	private String candidate_id;
	
	@Column(name = "start_date_time")
	private String start_date_time;
	
	@Column(name = "end_date_time")
	private String end_date_time;
	
	@Column(name = "exam_token")
	private String exam_token;
	
	@Column(name = "completed")
	private String completed;
	
	@Column(name = "exam_score")
	private String exam_score;
	
	@Column(name = "status")
	private String status;
	
	@JsonInclude
	@Transient
	private transient List<ExamResult> examResult;
	
	
	
	
	
	

}
