package com.themockmaster.tmmpayment.paystackmodels;

public class History {
	
	
	private String type;
	private String message;
	private Integer time;
	
	
	
	@Override
	public String toString() {
		return "History [type=" + type + ", message=" + message + ", time=" + time + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
	

}
