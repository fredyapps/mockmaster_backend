package com.themockmaster.tmmpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.themockmaster.tmmpayment.models.InitiatePayResponse;
import com.themockmaster.tmmpayment.models.Transaction;
import com.themockmaster.tmmpayment.models.Webhook_main_payload;
import com.themockmaster.tmmpayment.paystackmodels.InitiatePayRes;
import com.themockmaster.tmmpayment.paystackmodels.WebhookRes;
import com.themockmaster.tmmpayment.repository.TransactionRepository;
import com.themockmaster.tmmpayment.service.TmmPaymentService;

@RestController
@Validated
@RequestMapping(value = "/themockmasterAPIs/v2")
public class PaymentControllerV2 {

	@Autowired
	TmmPaymentService tmmpaymentservice;
	
	@Autowired
	TransactionRepository transRepo;
	
	@Value("${tmmpayment.verifyhash}")
	private String verifyhash;
	
	
	
	/** Initiate payment by sending user details to Paystack API and get
	  the payment URL in return containing the token of the transaction. **/
	@CrossOrigin(origins = "https://portal.mymockmaster.com",allowedHeaders = "*")
	//@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/InitiatePayment",method = RequestMethod.POST)
	public  ResponseEntity<?> initiatePaystackPayRequest(@RequestBody Transaction trans,
			@RequestHeader("offer") Integer offer) {
		
		InitiatePayRes res = new InitiatePayRes();
		
		try {
			
			trans.setOffer(offer);
			res = tmmpaymentservice.iniateTransactionV2(trans);
			
		}catch(Exception ex){
			
			System.out.println(ex);
		}		
		
		return new ResponseEntity<InitiatePayRes>(res, HttpStatus.OK);
		
	}
	
	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/webhook",method = RequestMethod.POST)
	public  ResponseEntity<?>  receivedDetailsOnWebhook(@RequestBody WebhookRes trans,@RequestHeader("x-paystack-signature") String verifyheader) {
		
		try {
			
			if(verifyhash.equals(verifyheader)) {
				
				tmmpaymentservice.updateTransactionStatusV2(trans);
				
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
	

	
	
	/** WebHook function used by FlatterWave to send the payment details with 
	 transaction status when after the user completes the transaction **/
	//@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin(origins = "https://portal.mymockmaster.com",allowedHeaders = "*")
	@RequestMapping(value = "/checkTransactionStatus/{ref}",method = RequestMethod.GET)
	public ResponseEntity<Object> receiveTransactionsDetails(@PathVariable String ref) {
		
		Object res = new Object();
		
		try {
			
		res = tmmpaymentservice.verifyTransactionV2(ref);
		
		System.out.println("========== printing response from flutterwave in controller ===========");
       System.out.println(res);
		
		}catch(Exception ex) {
			
		  System.out.println(ex);	
		}
		
		return new ResponseEntity<Object>(res, HttpStatus.OK);
		
	}
	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String gatewayDisplay() {
		
		return "Welcome to the mockmaster payment gateway V2!";
		
	}
	
	
	//x-paystack-signature
}
