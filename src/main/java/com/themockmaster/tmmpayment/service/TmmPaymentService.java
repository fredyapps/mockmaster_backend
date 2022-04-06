package com.themockmaster.tmmpayment.service;

import com.themockmaster.tmmpayment.models.InitiatePayRequest;
import com.themockmaster.tmmpayment.models.InitiatePayResponse;
import com.themockmaster.tmmpayment.models.Transaction;
import com.themockmaster.tmmpayment.models.Webhook_main_payload;

public interface TmmPaymentService {
	
	
	public Object verifyTransaction(Long transactionId) throws Exception;
	
	public <T> T iniateTransaction(Transaction paymentReq) throws Exception;
	
	public void updateTransactionStatus(Webhook_main_payload trans) throws Exception;

}
