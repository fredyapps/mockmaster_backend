package com.themockmaster.tmmpayment.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.themockmaster.tmmpayment.models.InitiatePayRequest;
import com.themockmaster.tmmpayment.models.InitiatePayResponse;
import com.themockmaster.tmmpayment.paystackmodels.InitiatePayReq;
import com.themockmaster.tmmpayment.paystackmodels.InitiatePayRes;
import com.themockmaster.tmmpayment.paystackmodels.TransactionObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class tmmpaymentClient {

	
	@Value("${tmmpayment.secret.key}")
	String secret_key;
	
	
	@Value("${paystack.secret.key}")
	String paystack_secret_key;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	/** This function Initiates a transaction by sending users details to FlutterWave
	  to get the payment Pop-up link in return  **/
	public InitiatePayResponse createInitiateFlutterPayment(final InitiatePayRequest request,
			final Class<InitiatePayResponse> responseType, final String address) throws RestClientException, Exception {
		InitiatePayResponse response = null;
		StopWatch timer = new StopWatch();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON.toString());
		httpHeaders.set("Authorization", "Bearer "+secret_key);
		HttpEntity<InitiatePayRequest> entity = new HttpEntity<InitiatePayRequest>(request, httpHeaders);

		timer.start();
		
		
		try {
			     response = (InitiatePayResponse) restTemplate
					.exchange(address, HttpMethod.POST, entity, InitiatePayResponse.class, (Object) responseType).getBody();
			     
			     System.out.println("========== printing createInitiate response from flutterwave in client===========");
				 System.out.println(response);
			
		} catch(Exception ex) {
				timer.stop();
				System.out.println("========== printing createInitiate exception from the client===========");
				System.out.println(ex);
		}
		if (response != null) {
			return response;
		}
		return response;
	}
	
	

	
	
	/** This function is called to verify the status of a transaction. On success , the user details is 
	 returned **/
	public Object createVerifyFlutterPayment(final String address) throws RestClientException, Exception {
		Object response = new Object();
		InitiatePayResponse re = new InitiatePayResponse();
		StopWatch timer = new StopWatch();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON.toString()); 
		httpHeaders.set("Authorization", "Bearer "+secret_key); //Authorization
		   
		HttpEntity<Object> entity = new HttpEntity<Object>(httpHeaders);

		timer.start();
		
		try {   
			    response = (Object) restTemplate
					.exchange(address, HttpMethod.GET, entity, Object.class, (Object) Object.class).getBody();
			    
			    System.out.println("========== printing response from flutterwave in client===========");
			    System.out.println(response);
			    
		} catch(Exception ex) {
			timer.stop();
			System.out.println("========== printing exception from the client===========");
			System.out.println(ex.getMessage());
			
			re.setStatus("error");
			re.setMessage("No transaction was found for this id");
			re.setData(null);
			
			return re;
		}
		
		return response;
	}
	
	
	
	
	
	
	/** This function is called to verify the status of a transaction. On success , the user details is 
	 returned **/
	public TransactionObject createVerifyPaystackPayment(final String address) throws RestClientException, Exception {
		ResponseEntity<TransactionObject> response = null;
		TransactionObject re = new TransactionObject();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("user-agent", "Application");
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);; 
		httpHeaders.add("Authorization", "Bearer "+paystack_secret_key); //Authorization
		HttpEntity<Object> entity = new HttpEntity<Object>(httpHeaders);
		
		//========
	
		
		//========

		
		
		try {   
			    response = restTemplate.exchange(address, HttpMethod.GET, entity, TransactionObject.class);
			    
			    
			    
			    System.out.println("========== printing response from Paystack in client===========");
			    System.out.println(response);
			    
		} catch(Exception ex) {
			
			System.out.println("========== printing exception from the client===========");
			System.out.println(ex.getMessage());
			
			
			re.setStatus(false);
			re.setMessage("No transaction was found for this id");
			re.setData(null);
			
			return re;
		}
		
		return response.getBody();
	}
	
	
	/** This function Initiates a transaction by sending users details to Paystack
	  to get the payment Pop-up link in return  **/
	public InitiatePayRes createInitiatePaystackPayment(final InitiatePayReq request,
			final Class<InitiatePayRes> responseType, final String address) throws RestClientException, Exception{
		
	     System.out.println("========== printing request payload===========");
		 System.out.println(request);
		
		//request.setAmount("3000");
		ResponseEntity<InitiatePayRes> response = null;
		//StopWatch timer = new StopWatch();
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer "+paystack_secret_key);
		HttpEntity<InitiatePayReq> entity = new HttpEntity<>(request,headers);
		
		 
	
	  
		try {
			     //response = (InitiatePayRes) restTemplate
				//	.exchange(address, HttpMethod.POST, entity, InitiatePayRes.class, (Object) responseType).getBody();
				response = restTemplate.exchange(address, HttpMethod.POST, entity, InitiatePayRes.class);
			     System.out.println("========== printing createInitiate response from paystack in client===========");
				 System.out.println(response);
			
		} catch(Exception ex) {
				//timer.stop();
				System.out.println("========== printing createInitiate exception from the paystack client===========");
				System.out.println(ex);
		}
			
			
		if (response != null) {
			
			return response.getBody();
		}
		
		    return response.getBody();
	
	}
	
	

	
	
}
