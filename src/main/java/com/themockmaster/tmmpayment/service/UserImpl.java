package com.themockmaster.tmmpayment.service;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themockmaster.tmmpayment.interfaces.*;
import com.themockmaster.tmmpayment.models.Candidate;
import com.themockmaster.tmmpayment.models.CandidateToken;
import com.themockmaster.tmmpayment.repository.CandidateRepository;
import com.themockmaster.tmmpayment.repository.TokenRepository;
import com.themockmaster.tmmpayment.utils.Controls;

@Service
public class UserImpl implements UserInterface{
	
	
	@Autowired
	CandidateRepository candidaterepo;
	
	@Autowired
	TokenRepository tokenRepo;
	
	@Override
	public Candidate registerCandidate(Candidate user){
		   
		   Candidate candidate = candidaterepo.getCandidateByEmail(user.getEmail());
		   
		   if(candidate==null) {
			        
			   // storing the new candidate
				    user.setRole("user");
				    user.setDate_created(Controls.returnDateTime());
				    System.out.println(user); 
				    Candidate savedCand = candidaterepo.save(user);
			    
			    // creating a token instance for new candidate for session
					CandidateToken auth_token = insertLoginToken(savedCand.getEmail());
					savedCand.setToken(auth_token.getToken());
					savedCand.setPassword(null);
				   
				    return savedCand;
			   
		   }else {
			   
			        return null;
		   }
		  
		
	}
	
	
	
	
	
	@Override
	public Candidate authenticateCandidate(HashMap<String,String> userCredentials){
		
		String email = userCredentials.get("email");
		String password = userCredentials.get("password");
		
		Candidate user = candidaterepo.getCandidateByEmail(email);
		
		if(password.equals(user.getPassword())) {
			
			CandidateToken auth_token = insertLoginToken(email);
			user.setToken(auth_token.getToken());
			user.setPassword(null);
			
			return user;
			
		}else {
			
			return null;
		}
		
	}
	
	
	public CandidateToken insertLoginToken(String email) {
		
		String token = Controls.generateTokenString(24);
		
		CandidateToken auth_token = new CandidateToken();
		auth_token.setToken(token);
		auth_token.setEmail(email);
		auth_token.setDate_created(Controls.returnDateTime());
		
		return tokenRepo.save(auth_token);
		
	}
	
	
	
	
	
	public void logoutCandidate(String user_token) {
		
		CandidateToken candidtoken = new CandidateToken();
		candidtoken = tokenRepo.verifyCandidateByToken(user_token);
		
		System.out.println(candidtoken);
		
		tokenRepo.delete(candidtoken);
		
	}
	
	
	
	public Candidate  getUserDetails(String user_token) {
		
		
		CandidateToken candidtoken = new CandidateToken();
		candidtoken = tokenRepo.verifyCandidateByToken(user_token);
		
		Candidate user = candidaterepo.getCandidateByEmail(candidtoken.getEmail());
		
		if(user!=null) {
			
			return user;
			
		}else {
			
			return null;
			
		}
		
		
		
	}
	
	
	
	
	
	
	

}
