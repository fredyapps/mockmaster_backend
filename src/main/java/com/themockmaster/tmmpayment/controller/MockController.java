package com.themockmaster.tmmpayment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.themockmaster.tmmpayment.mockmodels.Domain;
import com.themockmaster.tmmpayment.mockmodels.ErrorModel;
import com.themockmaster.tmmpayment.mockmodels.Mock;
import com.themockmaster.tmmpayment.mockmodels.Offers;
import com.themockmaster.tmmpayment.mockmodels.Question;
import com.themockmaster.tmmpayment.mockservice.MockService;
import com.themockmaster.tmmpayment.models.Transaction;
import com.themockmaster.tmmpayment.repository.DomainRepository;
import com.themockmaster.tmmpayment.repository.OptionRepository;
import com.themockmaster.tmmpayment.repository.QuestionRepository;
import com.themockmaster.tmmpayment.utils.Controls;


@RestController
@Validated
@RequestMapping(value = "/examAPIs/v1")
@CrossOrigin(origins = "https://tmmfrontend.herokuapp.com",allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:3000")
public class MockController {
	
	
	@Autowired
	QuestionRepository questionRepo;
	
	
	@Autowired
	OptionRepository optionRepo;
	
	
	@Autowired
	MockService mockservice;
	
	
	@Autowired
	Controls control;
	
	@Autowired
	DomainRepository domainRepo;
	
	/** Initiating a Mock exam by Generating a set of random question from the 5 differents cisa domains  **/
	
	@RequestMapping(value = "/cisaQuestions",method = RequestMethod.GET)
	public ResponseEntity<?> initiateFlatterwavePayRequest(@RequestHeader("user_token") String user_token) {
		
		 HashMap<String,Object> questions_and_mock = new HashMap();
		
		try {
			
			questions_and_mock = mockservice.createCISAMockExam(user_token);
			
				if(questions_and_mock!=null) {
					
					return new ResponseEntity<Object>(questions_and_mock, HttpStatus.OK);
					
				}else {
	        		
	        		ErrorModel err = new ErrorModel();
	        		err.setMessage("Sorry, No mock attempt remaining, Kindly buy a package");
	        		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
	        		
	        		return new ResponseEntity<ErrorModel>(err, HttpStatus.UNPROCESSABLE_ENTITY);
	        	}
        	
		     
			
		}catch(Exception ex){
	
    		
    		return new ResponseEntity<Object>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
		
		
		
	}
	
	
	
	
	/** Takes the candidate's answers as a parameter and generate the result based on the result formulas **/
	@RequestMapping(value = "/cisaResults",method = RequestMethod.POST)
	public ResponseEntity<?> generateCISAcandiateResults(@RequestBody List<Question> submittion,
			@RequestHeader("exam_token") String exam_token,
			@RequestHeader("user_token") String user_token){
		//@RequestBody List<Question> submittion
		  
		    Mock result = new Mock();
		
        try {
        	
        	if(control.checkingUser(user_token)){
        		
        		result = mockservice.generateCISAMockResult(submittion,exam_token);
        		
        		return new ResponseEntity<Mock>(result, HttpStatus.OK);
        		
        	}else {
        		
        		ErrorModel err = new ErrorModel();
        		err.setMessage("User does not exist");
        		err.setStatus(HttpStatus.NOT_FOUND);
        		
        		return new ResponseEntity<ErrorModel>(err, HttpStatus.NOT_FOUND);
        	}
        	
        	
		}catch(Exception ex){
			
			System.out.println(ex);
			
			return new ResponseEntity<Object>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
        
	}
	
	
	
	
	
	
	@RequestMapping(value = "/token",method = RequestMethod.GET)
	public String generateTokenString() {
		
		int len = 23;
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
		          +"lmnopqrstuvwxyz!@#$%&";
		
				Random rnd = new Random();
				StringBuilder sb = new StringBuilder(len);
				for (int i = 0; i < len; i++)
					sb.append(chars.charAt(rnd.nextInt(chars.length())));
				
				return sb.toString();
				
	}
	

	
	@RequestMapping(value = "/domains",method = RequestMethod.GET)
	public ResponseEntity<?> getdomains() {
	
		
       try {
    	   
    	    List<Domain> domains = new ArrayList<Domain>();
    	    domains = domainRepo.findDomainsByExam("CISA");
			
			return new ResponseEntity<Object>(domains, HttpStatus.OK);
		
		}catch (Exception ex){
			
			return new ResponseEntity<Object>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
		}
       
	}
	
	
	

	
	
	@RequestMapping(value = "/attempts",method = RequestMethod.GET)
	public ResponseEntity<?> getAvailableAtt(@RequestHeader("user_token") String user_token) {
	
		
       try {
    	   
		    	Transaction trans = new Transaction();
		   	    trans = mockservice.getAvailableAttempts(user_token);
		    	   
		   if(trans!=null) {
		    	 
					
					return new ResponseEntity<Transaction>(trans, HttpStatus.OK);
					
		       }else {
		   		
			   		ErrorModel err = new ErrorModel();
			   		err.setMessage("Sorry, No mock attempt remaining, Kindly buy a package");
			   		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			   		
			   		return new ResponseEntity<ErrorModel>(err, HttpStatus.UNPROCESSABLE_ENTITY);
		   	}
		
		}catch (Exception ex){
			
			return new ResponseEntity<Object>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
		}
       
	}
	
	
	
	
	
	

	@RequestMapping(value = "/packages",method = RequestMethod.GET)
	public ResponseEntity<?> listPackages() {
		
		List<Offers> packages = new ArrayList<Offers>();
		
		try {
			
			packages = mockservice.listOfferPackages("CISA");
		
			return new ResponseEntity<Object>(packages, HttpStatus.OK);
		
		}catch (Exception ex){
			
			return new ResponseEntity<Object>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
	}
	
	
	
	

	@RequestMapping(value = "/my_mocks",method = RequestMethod.GET)
	public ResponseEntity<?> list_candidate_mocks(@RequestHeader("user_token") String user_token) {
		
		List<Mock> my_mocks = new ArrayList<Mock>();
		
		try {
			
			my_mocks = mockservice.listCandidateMocks(user_token);
			
			if(my_mocks!=null) {
				
				return new ResponseEntity<Object>(my_mocks, HttpStatus.OK);
				
			}else {
				
				ErrorModel err = new ErrorModel();
        		err.setMessage("Sorry, your session has timeed out.");
        		err.setStatus(HttpStatus.NOT_FOUND);
        		
        		return new ResponseEntity<ErrorModel>(err, HttpStatus.NOT_FOUND);
				
			}
		
			
		}catch (Exception ex){
			
			    return new ResponseEntity<Object>(ex, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		
	}

}
