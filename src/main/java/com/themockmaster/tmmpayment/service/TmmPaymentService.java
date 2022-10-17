package com.themockmaster.tmmpayment.service;

import com.themockmaster.tmmpayment.models.InitiatePayRequest;
import com.themockmaster.tmmpayment.models.InitiatePayResponse;
import com.themockmaster.tmmpayment.models.Transaction;
import com.themockmaster.tmmpayment.models.Webhook_main_payload;
import com.themockmaster.tmmpayment.paystackmodels.InitiatePayReq;
import com.themockmaster.tmmpayment.paystackmodels.InitiatePayRes;
import com.themockmaster.tmmpayment.paystackmodels.WebhookRes;

public interface TmmPaymentService {
	
	
	
//=================================V1 functions=====================================
	
	public Object verifyTransaction(Long transactionId) throws Exception;
	
	public <T> T iniateTransaction(Transaction paymentReq) throws Exception;
	
	public void updateTransactionStatus(Webhook_main_payload trans) throws Exception;
	
	
	
	
//=================================V2 functions======================================
	public InitiatePayRes iniateTransactionV2(Transaction paymentReq) throws Exception;
	
	public Object verifyTransactionV2(String transactionId) throws Exception;
	
	public void updateTransactionStatusV2(WebhookRes trans) throws Exception;
	
	

}
