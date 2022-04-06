package com.themockmaster.tmmpayment.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.themockmaster.tmmpayment.mockmodels.Candidate;
import com.themockmaster.tmmpayment.repository.CandidateRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class Controls {
	
	
	@Autowired
	CandidateRepository candidaterepo;
	
	public  boolean checkingUser(String candidate_token) {
		
		Candidate candid = new Candidate();
		
	    candid = candidaterepo.getCandidateByToken(candidate_token);
	    
	    System.out.println("================== printing candidate ===================");
	    
	    System.out.println(candidaterepo.getCandidateByToken(candidate_token));
		
		if(candid!=null) {
			
			return true;
			
		}else {
			  
			return false;
		}
		
		
	}
	
	
	

}
