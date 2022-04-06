package com.themockmaster.tmmpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.themockmaster.tmmpayment.models.InitiatePayRequest;
import com.themockmaster.tmmpayment.models.InitiatePayResponse;
import com.themockmaster.tmmpayment.models.Transaction;
import com.themockmaster.tmmpayment.models.Webhook_main_payload;
import com.themockmaster.tmmpayment.repository.TransactionRepository;
import com.themockmaster.tmmpayment.service.TmmPaymentService;



@RestController
@Validated
@RequestMapping(value = "/themockmasterAPIs/v1")
public class PaymentController {
	
	
	@Autowired
	TmmPaymentService tmmpaymentservice;
	
	@Autowired
	TransactionRepository transRepo;
	
	@Value("${tmmpayment.verifyhash}")
	private String verifyhash;
	
	
	/** Initiate payment by sending user details to FlatterWave API and get
	  the payment URL in return containing the token of the transaction. **/
	@RequestMapping(value = "/InitiatePayment",method = RequestMethod.POST)
	public ResponseEntity<?> initiateFlatterwavePayRequest(@RequestBody Transaction trans) {
		
		InitiatePayResponse res = new InitiatePayResponse();
		
		try {
			
			res = tmmpaymentservice.iniateTransaction(trans);
			
		}catch(Exception ex){
			
			System.out.println(ex);
		}
//		
		
		
		return new ResponseEntity<InitiatePayResponse>(res, HttpStatus.OK);
		
	}
	
	
	
	/** WebHook function used by FlatterWave to send the payment details with 
	 transaction status when after the user completes the transaction **/
	@RequestMapping(value = "/checkTransactionStatus/{ref}",method = RequestMethod.GET)
	public ResponseEntity<Object> receiveTransactionsDetails(@PathVariable Long ref) {
		
		Object res = new Object();
		
		try {
			
		res = tmmpaymentservice.verifyTransaction(ref);
		
		System.out.println("========== printing response from flutterwave in controller ===========");
        System.out.println(res);
		
		}catch(Exception ex) {
			
		  System.out.println(ex);	
		}
		
		return new ResponseEntity<Object>(res, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/webhook",method = RequestMethod.POST)
	public  ResponseEntity<?>  receivedDetailsOnWebhook(@RequestBody Webhook_main_payload trans,@RequestHeader("verif-hash") String verifheader) {
		
		try {
			
			if(verifyhash.equals(verifheader)) {
				
				tmmpaymentservice.updateTransactionStatus(trans);
				
				return new ResponseEntity<String>("Success", HttpStatus.OK);
				
			}else {
				return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
			}
			
		
		
		}catch(Exception ex){
			
			System.out.println("========== printing webhook Exception in controller ===========");
	        System.out.println(ex);
	        return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
		}
	    
		
		
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String gatewayDisplay() {
		
		return "Welcome to the mockmaster payment gateway!";
		
	}

}
