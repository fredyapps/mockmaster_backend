package com.themockmaster.tmmpayment.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.themockmaster.tmmpayment.mockmodels.Domain;
import com.themockmaster.tmmpayment.mockmodels.Question;
import com.themockmaster.tmmpayment.models.Candidate;
import com.themockmaster.tmmpayment.models.CandidateToken;
import com.themockmaster.tmmpayment.repository.CandidateRepository;
import com.themockmaster.tmmpayment.repository.DomainRepository;
import com.themockmaster.tmmpayment.repository.TokenRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class Controls {
	
	
	private static final String EMPTY_STRING = "";
	
	
	
	@Autowired
	static DomainRepository domainRepo;
	
	
	
	
	@Autowired
	CandidateRepository candidaterepo;
	
	@Autowired
	TokenRepository tokenRepo;
	
	public  boolean checkingUser(String candidate_token) {
		
		CandidateToken candidtoken = new CandidateToken();
		
		candidtoken = tokenRepo.verifyCandidateByToken(candidate_token);
	    
	    System.out.println("================== printing token  ===================");
	    
	    System.out.println(candidaterepo.getCandidateByToken(candidate_token));
		
		if(candidtoken!=null) {
			
			return true;
			
		}else {
			  
			return false;
		}
		
		
	}
	
	
	
	public  String returnUser(String candidate_token) {
		
		CandidateToken candidtoken = new CandidateToken();
		
		candidtoken = tokenRepo.verifyCandidateByToken(candidate_token);
	    
	    System.out.println("================== printing token  ===================");
	    
	    System.out.println(candidaterepo.getCandidateByToken(candidate_token));
		
		if(candidtoken!=null) {
			
			return candidtoken.getEmail();
			
		}else {
			  
			return null;
		}
		
		
	}
	
	
	
	
	/**
	 * Method to check whether null or empty for all types of objects.
	 * 
	 * @param objects
	 * @return
	 */
	public static boolean isNotNullOrNotEmpty(final Object... objects) {
		boolean flag = false;
		flag = (Objects.nonNull(objects) && objects.length > 0);
		if (flag) {
			for (Object object : objects) {
				flag = Objects.nonNull(object);
				if (flag) {
					if (object instanceof Collection<?>) {
						Collection<?> c = (Collection<?>) object;
						flag = !c.isEmpty();
					} else if (object instanceof Map<?, ?>) {
						Map<?, ?> map = (Map<?, ?>) object;
						flag = !map.isEmpty();
					} else if (object instanceof String) {
						String str = (String) object;
						flag = !EMPTY_STRING.equals(str.trim());
					} else if (object instanceof StringBuilder) {
						StringBuilder str = (StringBuilder) object;
						flag = !EMPTY_STRING.equals(str.toString().trim());
					} else if (object instanceof StringBuffer) {
						StringBuffer str = (StringBuffer) object;
						flag = !EMPTY_STRING.equals(str.toString().trim());
					} else if (object instanceof Object[]) {
						Object[] arrObj = (Object[]) object;
						flag = arrObj.length > 0;
					}
					if (!flag) {
						break;
					}
				} else {
					break;
				}
			}
		}
		return flag;
	}
	
	
    public static String generateTokenString(int len) {
		
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
		          +"lmnopqrstuvwxyz!@#$%&";
		
				Random rnd = new Random();
				StringBuilder sb = new StringBuilder(len);
				for (int i = 0; i < len; i++)
					sb.append(chars.charAt(rnd.nextInt(chars.length())));
				return sb.toString();
				
	}
    
    
    public static String returnDateTime() {
    	
 	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   LocalDateTime now = LocalDateTime.now();
	   String created_at = dtf.format(now).toString();
	   
	   return created_at;
    }
    
    

	
	

}
