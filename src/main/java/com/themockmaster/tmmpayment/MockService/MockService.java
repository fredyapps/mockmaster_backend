package com.themockmaster.tmmpayment.mockservice;

import java.util.List;

import com.themockmaster.tmmpayment.mockmodels.Mock;
import com.themockmaster.tmmpayment.mockmodels.Question;

public interface MockService {
	
	
	public <T> T createCISAMockExam(String user_token) throws Exception;
	
	
	public Mock generateCISAMockResult(List<Question> submittion,String exam_token) throws Exception;

}
