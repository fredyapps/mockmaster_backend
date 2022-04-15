package com.themockmaster.tmmpayment.mockservice;

import java.util.List;

import com.themockmaster.tmmpayment.mockmodels.Mock;
import com.themockmaster.tmmpayment.mockmodels.Offers;
import com.themockmaster.tmmpayment.mockmodels.Question;
import com.themockmaster.tmmpayment.models.Transaction;

public interface MockService {
	
	
	public <T> T createCISAMockExam(String user_token) throws Exception;
	
	
	public Mock generateCISAMockResult(List<Question> submittion,String exam_token) throws Exception;
	
	
	public  List<Offers> listOfferPackages(String exam) throws Exception;
	
	
	public List<Mock> listCandidateMocks(String user_token) throws Exception;
	
	
	public Transaction getAvailableAttempts(String user_token) throws Exception;
 
}
