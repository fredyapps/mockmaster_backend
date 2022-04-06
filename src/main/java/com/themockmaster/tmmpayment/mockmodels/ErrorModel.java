package com.themockmaster.tmmpayment.mockmodels;

import org.springframework.http.HttpStatus;

public class ErrorModel {
	
	
//	{
//	    "timestamp": "2022-03-29T16:12:24.140+00:00",
//	    "status": 404,
//	    "error": "Not Found",
//	    "message": "No message available",
//	    "path": "/examAPIs/v1/gatewa"
//	}
	
	private String timestamp;
	@Override
	public String toString() {
		return "ErrorModel [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message=" + message
				+ ", path=" + path + "]";
	}
	
	public  ErrorModel() {}
	private HttpStatus status;
	private String error;
	private String message;
	private String path=null;
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
