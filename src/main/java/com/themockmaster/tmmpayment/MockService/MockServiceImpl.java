package com.themockmaster.tmmpayment.mockservice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themockmaster.tmmpayment.mockmodels.Domain;
import com.themockmaster.tmmpayment.mockmodels.ExamResult;
import com.themockmaster.tmmpayment.mockmodels.Mock;
import com.themockmaster.tmmpayment.mockmodels.Offers;
import com.themockmaster.tmmpayment.mockmodels.Question;
import com.themockmaster.tmmpayment.models.Candidate;
import com.themockmaster.tmmpayment.models.CandidateToken;
import com.themockmaster.tmmpayment.models.Transaction;
import com.themockmaster.tmmpayment.repository.CandidateRepository;
import com.themockmaster.tmmpayment.repository.DomainRepository;
import com.themockmaster.tmmpayment.repository.ExamResultRepository;
import com.themockmaster.tmmpayment.repository.MockRepository;
import com.themockmaster.tmmpayment.repository.OfferRepository;
import com.themockmaster.tmmpayment.repository.OffersItemsRepository;
import com.themockmaster.tmmpayment.repository.OptionRepository;
import com.themockmaster.tmmpayment.repository.QuestionRepository;
import com.themockmaster.tmmpayment.repository.TokenRepository;
import com.themockmaster.tmmpayment.repository.TransactionRepository;
import com.themockmaster.tmmpayment.utils.Controls;

@Service
public class MockServiceImpl implements MockService {
	
	
	
	@Autowired
	QuestionRepository questionRepo;
	
	@Autowired
	OptionRepository optionRepo;
	
	@Autowired
	MockRepository mockRepo;
	
	@Autowired
	ExamResultRepository resultRepo;
	
	@Autowired
	TokenRepository tokenRepo;
	
	@Autowired
	CandidateRepository candidaterepo;
	
	@Autowired
	OfferRepository offerRepo;
	
	@Autowired
	OffersItemsRepository itemRepo;
	
	@Autowired
	DomainRepository domainRepo;
	
	
	@Autowired
	TransactionRepository transRepo;
	
	@Autowired
	Controls control;
	
	
	private  String[] domains = {"CISA_DOM1", "CISA_DOM2", "CISA_DOM3", "CISA_DOM4", "CISA_DOM5"};
	
	private  String[] cism_domains = {"CISM_DOM1","CISM_DOM2","CISM_DOM3","CISM_DOM4"};
	
	
	@Override
	public HashMap<String,Object> createCISAMockExam(String user_token){
		
		HashMap<String,Object> ret = new HashMap<String,Object>();
		List<Question> questions = new ArrayList<Question>();
		
		
		Mock mock = this.createTheMockExam(user_token , "CISA");
		
		
		if(mock!= null) {
			
			List<Question> dom1questions = questionRepo.pull_cisa_questions(domains[0],31);
			List<Question> dom2questions = questionRepo.pull_cisa_questions(domains[1],25);
			List<Question> dom3questions = questionRepo.pull_cisa_questions(domains[2],18);
			List<Question> dom4questions = questionRepo.pull_cisa_questions(domains[3],35);
			List<Question> dom5questions = questionRepo.pull_cisa_questions(domains[4],41);
			
			
			  for (Question question : dom1questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
			  
			  for (Question question : dom2questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
			  
			  for (Question question : dom3questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
			  
			  for (Question question : dom4questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
			  
			  for (Question question : dom5questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
		        
		        ret.put("questions", questions);
		        ret.put("mock", mock);
		        
		}else{
			
			ret = null;
		}

	            
		return ret;
		
	}
	
	
	
	public HashMap<String,Object> createCISMMockExam(String user_token){
		
		HashMap<String,Object> ret = new HashMap<String,Object>();
		List<Question> questions = new ArrayList<Question>();
		
		Mock mock = this.createTheMockExam(user_token , "CISM");
		
		
		if(mock!= null) {
			
			List<Question> dom1questions = questionRepo.pull_cisa_questions(cism_domains[0],25);
			List<Question> dom2questions = questionRepo.pull_cisa_questions(cism_domains[1],30);
			List<Question> dom3questions = questionRepo.pull_cisa_questions(cism_domains[2],50);
			List<Question> dom4questions = questionRepo.pull_cisa_questions(cism_domains[3],45);
		
			
			
			  for (Question question : dom1questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
			  
			  for (Question question : dom2questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
			  
			  for (Question question : dom3questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
			  
			  for (Question question : dom4questions)
		        {
				  question.setOptions(optionRepo.findOptionsByquestion(question.getQuestion_id()));
				  questions.add(question);
		        };
			  
			
		        
		        ret.put("questions", questions);
		        ret.put("mock", mock);
		        
		}else{
			
			ret = null;
		}
		
		return ret;
	}
	
	
	
	
	
	public Mock createTheMockExam(String user_token, String exam_id) {
		
		Mock themock = new Mock();
		//Transaction trans = new Transaction();
		List<Transaction> trans = new ArrayList();
        CandidateToken candidtoken = new CandidateToken();
        
        candidtoken = tokenRepo.verifyCandidateByToken(user_token);
        
        trans = transRepo.getRemainingAttemptsPerExam(candidtoken.getEmail(),exam_id);
        
        if(trans.get(0)!= null && trans.get(0).getAttempts() > 0) {
        	
        	   trans.get(0).setAttempts(trans.get(0).getAttempts()- 1);
        	
        	   Candidate cand = new Candidate();
               
               cand = candidaterepo.getCandidateByEmail(candidtoken.getEmail());
               
               
               themock.setExam_id(exam_id);
               themock.setCandidate_id(cand.getEmail());
               themock.setExam_token(this.generateTokenString(10));
               themock.setStart_date_time(Controls.returnDateTime());
               themock.setCompleted("No");
               themock.setPayment_ref(trans.get(0).getReference());
               
               mockRepo.save(themock);
        	
        }else {
        	
        	themock = null;
        }
        
		return themock;
		
	}
	
	


	@Override
	public Mock generateCISAMockResult(List<Question> submittion,  String exam_token){
		
		Mock themock = new Mock();

		HashMap<String,Double> firstScoreMap  = new HashMap<String,Double>();
		HashMap<String,Double> secondScoreMap = new HashMap<String,Double>();
		HashMap<String,String> token_and_exam = new HashMap<String,String>();
		
		token_and_exam.put("exam_token", exam_token);
		token_and_exam.put("exam_name", "CISA");
		
		Double CISA_DOM1 = 0.0; Double CISA_DOM2 = 0.0; Double CISA_DOM3 = 0.0; Double CISA_DOM4 = 0.0; Double CISA_DOM5 = 0.0;
		Double overAllScore = 0.0;
		for(Question candAnswers:submittion) {
			
			if(candAnswers.getDomain_id().equals(domains[0])) {
				
				if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
					
					CISA_DOM1 = CISA_DOM1 + 25.81;
					
				}
			}
			
            if(candAnswers.getDomain_id().equals(domains[1])) {
            	
               if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
					
					CISA_DOM2 = CISA_DOM2 + 32.00;
					
				}
			}
            
            if(candAnswers.getDomain_id().equals(domains[2])) {
            	
            	if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
 					
 					CISA_DOM3 = CISA_DOM3 + 44.44;
 					
 				}
				
			}
            
            if(candAnswers.getDomain_id().equals(domains[3])) {
            	
            	 if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
 					
 					CISA_DOM4 = CISA_DOM4 + 22.86;
 					
 				}
				
			}
            
            if(candAnswers.getDomain_id().equals(domains[4])) {
            	
            	 if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
 					
 					CISA_DOM5 = CISA_DOM5 + 19.51;
 					
 				}
				
			}
		}
		
		firstScoreMap.put(domains[0], CISA_DOM1);
		firstScoreMap.put(domains[1], CISA_DOM2);
		firstScoreMap.put(domains[2], CISA_DOM3);
		firstScoreMap.put(domains[3], CISA_DOM4);
		firstScoreMap.put(domains[4], CISA_DOM5);
		
		// generate the second phase of scores for each domain
		secondScoreMap = generateCISASecondScore(firstScoreMap);
		
		//calculate overAllScore for the CISA exam
		overAllScore =  calculateoverAllScore(secondScoreMap, "CISA");
		
		 themock = storeExamResults( firstScoreMap,  secondScoreMap , overAllScore, token_and_exam);
		
		return themock;
		
	}
	
	
	
	
	
public Mock generateCISMMockResult(List<Question> submittion,  String exam_token){
		
		Mock themock = new Mock();

		HashMap<String,Double> firstScoreMap = new HashMap<String,Double>();
		HashMap<String,Double> secondScoreMap = new HashMap<String,Double>();
		HashMap<String,String> token_and_exam = new HashMap<String,String>();
		
		token_and_exam.put("exam_token", exam_token);
		token_and_exam.put("exam_name", "CISM");
		
		Double CISM_DOM1 = 0.0; Double CISM_DOM2 = 0.0; Double CISM_DOM3 = 0.0; Double CISM_DOM4 = 0.0; Double CISM_DOM5 = 0.0;
		Double overAllScore = 0.0;
		for(Question candAnswers:submittion) {
			
			if(candAnswers.getDomain_id().equals(domains[0])) {
				
				if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
					
					CISM_DOM1 = CISM_DOM1 + 22.22;
					
				}
			}
			
            if(candAnswers.getDomain_id().equals(domains[1])) {
            	
               if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
					
					CISM_DOM2 = CISM_DOM2 + 17.78;
					
				}
			}
            
            if(candAnswers.getDomain_id().equals(domains[2])) {
            	
            	if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
 					
 					CISM_DOM3 = CISM_DOM3 + 19.51;
 					
 				}
				
			}
            
            if(candAnswers.getDomain_id().equals(domains[3])) {
            	
            	 if(candAnswers.getQuestion_answer().equals(candAnswers.getCandidateAnswer())) {
 					
 					CISM_DOM4 = CISM_DOM4 + 28.57;
 					
 				}
				
			}
            
         
		}
		
		firstScoreMap.put(domains[0], CISM_DOM1);
		firstScoreMap.put(domains[1], CISM_DOM2);
		firstScoreMap.put(domains[2], CISM_DOM3);
		firstScoreMap.put(domains[3], CISM_DOM4);

		
		// generate the second phase of scores for each domain
		secondScoreMap = generateCISMSecondScore(firstScoreMap);
		
		//calculate overAllScore for the CISA exam
		overAllScore =  calculateoverAllScore(secondScoreMap, "CISM");
		
		 themock = storeExamResults( firstScoreMap,  secondScoreMap , overAllScore, token_and_exam);
		
		return themock;
		
	}
	
	
	
	/** Takes a HashMap of domain scores to calculate the second phase of scores following the domain weight. **/
	public HashMap<String,Double> generateCISASecondScore(HashMap<String,Double> firstScoreMap){
		
		HashMap<String,Double> secondScoreMap = new HashMap<String,Double>();
		
		Double CISA_DOM1 = 0.0; Double CISA_DOM2 = 0.0; Double CISA_DOM3 = 0.0; Double CISA_DOM4 = 0.0; Double CISA_DOM5 = 0.0;
		
		CISA_DOM1 = (firstScoreMap.get(domains[0])*21)/100;
		CISA_DOM2 = (firstScoreMap.get(domains[1])*17)/100;
		CISA_DOM3 = (firstScoreMap.get(domains[2])*12)/100;
		CISA_DOM4 = (firstScoreMap.get(domains[3])*23)/100;
		CISA_DOM5 = (firstScoreMap.get(domains[4])*27)/100;
		
		secondScoreMap.put(domains[0], CISA_DOM1);
		secondScoreMap.put(domains[1], CISA_DOM2);
		secondScoreMap.put(domains[2], CISA_DOM3);
		secondScoreMap.put(domains[3], CISA_DOM4);
		secondScoreMap.put(domains[4], CISA_DOM5);
		
		return secondScoreMap;
		
	}
	
	
	
	/** Takes a HashMap of domain scores to calculate the second phase of scores following the domain weight. **/
	public HashMap<String,Double> generateCISMSecondScore(HashMap<String,Double> firstScoreMap){
		
		HashMap<String,Double> secondScoreMap = new HashMap<String,Double>();
		
		Double CISM_DOM1 = 0.0; Double CISM_DOM2 = 0.0; Double CISM_DOM3 = 0.0; Double CISM_DOM4 = 0.0;
		
		CISM_DOM1 = (firstScoreMap.get(domains[0])*17)/100;
		CISM_DOM2 = (firstScoreMap.get(domains[1])*20)/100;
		CISM_DOM3 = (firstScoreMap.get(domains[2])*33)/100;
		CISM_DOM4 = (firstScoreMap.get(domains[3])*30)/100;
	
		
		secondScoreMap.put(domains[0], CISM_DOM1);
		secondScoreMap.put(domains[1], CISM_DOM2);
		secondScoreMap.put(domains[2], CISM_DOM3);
		secondScoreMap.put(domains[3], CISM_DOM4);
		
		return secondScoreMap;
		
	}
	
	
	
	public Double calculateoverAllScore( HashMap<String,Double> secondScoreMap , String exam_id) {
		
		Double overAllScore = 0.0;
		String examid = exam_id;
		
		if(examid.equals("CISA")) {
			
			overAllScore = secondScoreMap.get(domains[0])+ secondScoreMap.get(domains[1]) + secondScoreMap.get(domains[2])
            + secondScoreMap.get(domains[3]) + secondScoreMap.get(domains[4]);
			
		}else if(examid.equals("CISM")) {
			
			overAllScore = secondScoreMap.get(domains[0])+ secondScoreMap.get(domains[1]) + secondScoreMap.get(domains[2])
            + secondScoreMap.get(domains[3]);
		}
		
		
		
		return overAllScore;
		
	}
	
	
	
	public String generateTokenString(int len) {
		
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
				Random rnd = new Random();
				StringBuilder sb = new StringBuilder(len);
				for (int i = 0; i < len; i++)
					sb.append(chars.charAt(rnd.nextInt(chars.length())));
				return sb.toString();
				
	}
	
	
	@Override
	public List<Offers> listOfferPackages(String exam){
		
		List<Offers> packages = new ArrayList<Offers>();
		
		packages = offerRepo.findPackagesByExam(exam);
		
		for(Offers offer:packages) {
			
			//offer.setItems(itemRepo.findItemsByPackage(offer.getPackage_id()));
			offer.setItems(itemRepo.findItemsByPackage(offer.getPackage_id()));
		}
		
		
		return packages;
		
	}
	

	
	
	public Mock storeExamResults(HashMap<String,Double> firstScoreMap, HashMap<String,Double> secondScoreMap ,Double overAllScore,HashMap<String,String> token_and_exam) {
		
		Date date = new Date();
		Boolean failed = false;
		String token = token_and_exam.get("exam_token");
		List<Domain> db_domains = new ArrayList() ;
	 
		Mock mockObj = mockRepo.getByToken(token);
		
		System.out.println("================== printing mock at line 232 ===================");
		    
		System.out.println(mockObj);
		   
		mockObj.setCompleted("yes");
	    mockObj.setEnd_date_time(new Timestamp(date.getTime()).toString());
	    int score = (int) Math.round(overAllScore);
	    
	    if(score <= 200) {
	    	score = 200;
	    }
	    
	    if(score >= 450) {
	    	mockObj.setStatus("Passed");
	    }else {
	    	mockObj.setStatus("Failed");
	    }
	    mockObj.setExam_score(String.valueOf(score));  
	    
	    // Updating the mock exam in the DB
	    Mock savedMock = mockRepo.save(mockObj);
	    
	    if(token_and_exam.get("exam_name").equals("CISA")){
	    
	    	  db_domains = domainRepo.findDomainsByExam("CISA");
	    	 
	    }else if(token_and_exam.get("exam_name").equals("CISM")){
	    
	          db_domains = domainRepo.findDomainsByExam("CISM");
	    
	    }
	    
	    
	    // Storing the result per domain
	    for (Domain me : db_domains ) {
	    	
	    	ExamResult exam_result = new ExamResult();
	    	exam_result.setExam_token(token);
	  	    exam_result.setExam_id(savedMock.getMockId());
	  	    exam_result.setDomain_id(me.getDomain_id());
	  	
	  	    int fscore = (int) Math.round(firstScoreMap.get(me.getDomain_id()));
	  	    int sscore = (int) Math.round(secondScoreMap.get(me.getDomain_id()));
	  	    if(fscore < 450) { failed = true;}
	  	    exam_result.setFirst_score(String.valueOf(fscore));
	  	    exam_result.setSecond_score(String.valueOf(sscore));
	  	    exam_result.setDomain(me.getDomain_text());
	  	    resultRepo.save(exam_result);
	    	
	    }
	    
	    if(failed) {
	    	 savedMock = mockRepo.getByToken(token);
	    	 savedMock.setStatus("Failed");
	    	 mockRepo.save(savedMock);
	    	
	    }
	    
	    List<ExamResult> exares = resultRepo.getByExam(savedMock.getExam_token());
	    
	    
	    
	    savedMock.setExamResult(exares);
	    
	    return savedMock;
	    
	    

		
	}
	
	
	@Override
	public List<Mock> listCandidateMocks(String user_token){
		
		List<Mock> mocks = new ArrayList<Mock>();
        CandidateToken candidtoken = new CandidateToken();
		
		candidtoken = tokenRepo.verifyCandidateByToken(user_token);
		
	    if(candidtoken!=null) {
			
	    	mocks = mockRepo.getMocksByCandidate(candidtoken.getEmail());
	    	
	    	for(Mock mock:mocks){
	    		
	    		List<ExamResult> examResult = resultRepo.getByExam(mock.getExam_token());
	    		mock.setExamResult(examResult);
	    	}
			
		}else {
			  
			mocks = null;
		}
	    
		return mocks;
	}
	
	
	
	
	
	@Override
	public List<Transaction> getAvailableAttempts(String user_token) {
		
		List<Transaction> trans = new ArrayList();
        CandidateToken candidtoken = new CandidateToken();
        
        candidtoken = tokenRepo.verifyCandidateByToken(user_token);
        //trans = transRepo.getRemainingAttempts(candidtoken.getEmail());
        
        if(candidtoken!=null) {
        	
        	trans = transRepo.getRemainingAttempts(candidtoken.getEmail());
        	
        }else {
        	
        	trans = null;
        }
        
        return trans;
		
	}
	
	
	
	
	
}
