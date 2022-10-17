package com.themockmaster.tmmpayment.paystackmodels;

import java.util.List;

public class TransLog {

	
	private Integer start_time;
	private Integer time_spent;
	private Integer attempts;
	private Integer errors;
	private boolean success;
	
	
	
	@Override
	public String toString() {
		return "TransLog [start_time=" + start_time + ", time_spent=" + time_spent + ", attempts=" + attempts
				+ ", errors=" + errors + ", success=" + success + ", mobile=" + mobile + ", input=" + input
				+ ", history=" + history + "]";
	}
	public Integer getStart_time() {
		return start_time;
	}
	public void setStart_time(Integer start_time) {
		this.start_time = start_time;
	}
	public Integer getTime_spent() {
		return time_spent;
	}
	public void setTime_spent(Integer time_spent) {
		this.time_spent = time_spent;
	}
	public Integer getAttempts() {
		return attempts;
	}
	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}
	public Integer getErrors() {
		return errors;
	}
	public void setErrors(Integer errors) {
		this.errors = errors;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isMobile() {
		return mobile;
	}
	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}
	public List<Object> getInput() {
		return input;
	}
	public void setInput(List<Object> input) {
		this.input = input;
	}
	public List<History> getHistory() {
		return history;
	}
	public void setHistory(List<History> history) {
		this.history = history;
	}
	private boolean mobile;
	private List<Object> input;
	private List<History> history;
}
