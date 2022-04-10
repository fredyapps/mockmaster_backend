package com.themockmaster.tmmpayment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.themockmaster.tmmpayment.interfaces.UserInterface;
import com.themockmaster.tmmpayment.mockmodels.ErrorModel;
import com.themockmaster.tmmpayment.models.Candidate;
import com.themockmaster.tmmpayment.utils.Controls;

@RestController
@Validated
@RequestMapping(value = "/onboarding/v1")
public class UserController {
	
	
	@Autowired
	UserInterface userinter;

	
	@CrossOrigin(origins = "https://tmmfrontend.herokuapp.com")
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public  ResponseEntity<?> register(@RequestBody Candidate candidate){
		
		Candidate user = null ;
		
		try {
			
		   user = userinter.registerCandidate(candidate);
		    
		   if(user==null) {
			   
			   ErrorModel err = new ErrorModel();
			   err.setMessage("Sorry,a candidate already exists with same email");
			   err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			   
			   return new ResponseEntity<ErrorModel>(err, HttpStatus.UNPROCESSABLE_ENTITY);
		   }
		 
		   return new ResponseEntity<Candidate>(user, HttpStatus.CREATED);
		
		}catch(Exception ex) {
			
		   return new ResponseEntity<Object>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
		 
		}
		
		
	}
	

	@CrossOrigin(origins = "https://tmmfrontend.herokuapp.com")
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public  ResponseEntity<?> login(@RequestBody HashMap<String,String> credentials){
		
		       Candidate user = null ;
		
		try {
			
		       user = userinter.authenticateCandidate(credentials);
		   
		   if(user==null) {
			   
			   ErrorModel err = new ErrorModel();
			   err.setMessage("Sorry,Wrong credentials");
			   err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			   
			   return new ResponseEntity<Object>(err, HttpStatus.UNPROCESSABLE_ENTITY);
		   }
		       user.setPassword(null);
		 
		       return new ResponseEntity<Candidate>(user, HttpStatus.CREATED);
		
		}catch(Exception ex) {
			
		       return new ResponseEntity<Object>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
		 
		}
		
		
	}
}
