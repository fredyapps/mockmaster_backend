package com.themockmaster.tmmpayment.interfaces;

import java.util.HashMap;

import com.themockmaster.tmmpayment.models.Candidate;


public interface UserInterface {

	
	public Candidate registerCandidate(Candidate user) throws Exception;
	
	public Candidate authenticateCandidate(HashMap<String,String> userCredentials)  throws Exception;
	
}
