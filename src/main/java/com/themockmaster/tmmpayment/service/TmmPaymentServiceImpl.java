package com.themockmaster.tmmpayment.service;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.themockmaster.tmmpayment.client.tmmpaymentClient;
import com.themockmaster.tmmpayment.models.Customer;
import com.themockmaster.tmmpayment.models.Customizations;
import com.themockmaster.tmmpayment.models.InitiatePayRequest;
import com.themockmaster.tmmpayment.models.InitiatePayResponse;
import com.themockmaster.tmmpayment.models.Meta;
import com.themockmaster.tmmpayment.models.Transaction;
import com.themockmaster.tmmpayment.models.Webhook_main_payload;
import com.themockmaster.tmmpayment.repository.TransactionRepository;

//import software.amazon.awssdk.services.sns.SnsClient;
//import software.amazon.awssdk.services.sns.model.PublishRequest;
//import software.amazon.awssdk.services.sns.model.PublishResponse;
//import software.amazon.awssdk.services.sns.model.SnsException;



@Service
public class TmmPaymentServiceImpl implements TmmPaymentService{
	
	
	@Autowired
	tmmpaymentClient client;

	@Value("${flatterwave.verify.uri}")
	private String verify_uri;

	@Value("${flatterwave.initiate.uri}")
	private String initiate_uri;
	
	@Value("${tmmpayment.logo.url}")
	private String logo_url;
	
	@Value("${tmmpayment.redirect_to_portal}")
	private String redirect_to_portal;
	
	
	@Autowired
	TransactionRepository transRepo;
	
	
	
	@Override
	public Object verifyTransaction(Long transactionId){
		
		
		Object res = new Object();
		
		System.out.println("========== printing flutterwave verify url ===========");
	    System.out.println(verify_uri+transactionId+"/verify");
		
		try {
			//JSONObject hh = new JSONObject();
	         res = client.createVerifyFlutterPayment(verify_uri+transactionId+"/verify");
	         
	         System.out.println("========== printing response from flutterwave in service ===========");
	         System.out.println(res);
	    
		}catch(Exception ex) {
			
			 System.out.println("========== printing flutterwave verify exception ===========");
			 System.out.println(ex);
		}
		
		
		return res;
	}
	
	
	@Override
	public void updateTransactionStatus(Webhook_main_payload transDetails) {
		
		 Transaction trans = transRepo.findByReference(transDetails.getData().getTx_ref());
		
		if(transDetails.getData().getStatus().equals("successful")) {
			
			 //updating the status of the transaction
			 trans.setCompleted("Yes");
			 trans.setTransaction_id(transDetails.getData().getId());
			 trans.setOperator_message(transDetails.getData().getProcessor_response());
			 
			   
			   //updating updated_at column in db
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			   LocalDateTime now = LocalDateTime.now();
			   String updated_at = dtf.format(now).toString();
			   
			   trans.setUpdated_at(updated_at);
			  
			   transRepo.save(trans);
			 
		}else {
			
			 trans.setOperator_message(transDetails.getData().getProcessor_response());
			 transRepo.save(trans);
		}
	}
	
	
	@Override
	public InitiatePayResponse iniateTransaction(Transaction paymentReq) {
		
		InitiatePayRequest  req = new InitiatePayRequest();
		InitiatePayResponse res = new InitiatePayResponse();
       
       try {
    	   
    	   String transRef = generateReference();
    	   
    	   System.out.println("========== printing transaction reference from flutterwave in service ===========");
	       System.out.println(transRef);
    	   
	       // assigning the transaction a reference number
    	   paymentReq.setReference(transRef);
    	   
    	   //inserting transaction into themockmaster DB
    	   transRepo.save(paymentReq);
    	   
    	   req = formInitiateReq(paymentReq);
    	  
    	   
    	    res = client.createInitiateFlutterPayment(req, InitiatePayResponse.class, initiate_uri);
    	   
    	   System.out.println("========== printing iniateTransaction response from flutterwave in service ===========");
	       System.out.println(res);
    	   
       }catch(Exception ex) {
    	   
    	   System.out.println("========== printing flutterwave iniateTransaction exception ===========");
		   System.out.println(ex);
    	   
       }
		
		
		return res;
	}
	
	
	public String generateReference() {

		Random random = new Random();   
		// Generates random integers 0 to 9  
		int x = random.nextInt(1000000000); 
		String x_string = String.valueOf(x);
		
		return x_string;
		
	}
	
	
	public InitiatePayRequest formInitiateReq(Transaction trans) {
		
		InitiatePayRequest iniReq = new InitiatePayRequest();
		
		//filling consumer information
		Meta meta = new Meta();
	    meta.setConsumer_id(22);
	    meta.setConsumer_mac("kueg937nfk-h7");
	    
	    
	    //filling candidate/payer information
	    Customer cust = new Customer();
	    cust.setEmail(trans.getEmail());
	    cust.setName(trans.getName());
	    cust.setPhonenumber(trans.getPhonenumber());
	    
	    
	    //filling customizations information
	    Customizations custmiz = new Customizations();
	    custmiz.setLogo(logo_url);
	    custmiz.setTitle(trans.getDescription());
	    
	    
	    //filling other infos
	    iniReq.setCustomer(cust);
	    iniReq.setMeta(meta);
	    iniReq.setCustomizations(custmiz);
	    iniReq.setTx_ref(trans.getReference());
	    iniReq.setAmount(trans.getAmount());
	    iniReq.setCurrency(trans.getCurrency());
	    iniReq.setRedirect_url(redirect_to_portal);
	    
	    
	  
		return iniReq;
		
	}
	
	
	
//    public static void pubTextSMS(SnsClient snsClient, String message, String phoneNumber) {
//    	
//    	
////    	   SnsClient snsClient = SnsClient.builder()
////                   .region(Region.US_WEST_2)
////                   .build();
////
////           pubTextSMS(snsClient, message, phoneNumber);
////           snsClient.close();
//           
//        try {
//            PublishRequest request = PublishRequest.builder()
//                .message(message)
//                .phoneNumber(phoneNumber)
//                .build();
//
//            PublishResponse result = snsClient.publish(request);
//            System.out.println(result.messageId() + " Message sent. Status was " + result.sdkHttpResponse().statusCode());
//
//        } catch (SnsException e) {
//            System.err.println(e.awsErrorDetails().errorMessage());
//            System.exit(1);
//        }
//    }



	
	
	
	

}
