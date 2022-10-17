package com.themockmaster.tmmpayment.paystackmodels;

public class TransactionObject {
	
	private boolean status;
	private String message;
	private Data_2 data;
	
	
	@Override
	public String toString() {
		return "TransactionObject [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Data_2 getData() {
		return data;
	}
	public void setData(Data_2 data) {
		this.data = data;
	}
	
	

}
