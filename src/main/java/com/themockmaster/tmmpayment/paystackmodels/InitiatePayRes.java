package com.themockmaster.tmmpayment.paystackmodels;

public class InitiatePayRes {

	
//	{
//		2  "status": true,
//		3  "message": "Authorization URL created",
//		4  "data": {
//		5    "authorization_url": "https://checkout.paystack.com/0peioxfhpn",
//		6    "access_code": "0peioxfhpn",
//		7    "reference": "7PVGX8MEk85tgeEpVDtD"
//		8  }
//		9}
	
	private boolean status;
	private String message;
	@Override
	public String toString() {
		return "InitiatePayRes [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	private Data_1 data;
	
	public boolean getStatus() {
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
	public Data_1 getData() {
		return data;
	}
	public void setData(Data_1 data) {
		this.data = data;
	}
	
	
	
	
}
