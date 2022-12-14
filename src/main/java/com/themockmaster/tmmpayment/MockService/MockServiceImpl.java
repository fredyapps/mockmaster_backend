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
	
	
	@Override
	public HashMap<String,Object> createCISAMockExam(String user_token){
		
		HashMap<String,Object> ret = new HashMap<String,Object>();
		List<Question> questions = new ArrayList<Question>();
		
		
		Mock mock = this.createTheMockExam(user_token);
		
		
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
	
	
	
	
	public Mock createTheMockExam(String user_token) {
		
		Mock themock = new Mock();
		Transaction trans = new Transaction();
        CandidateToken candidtoken = new CandidateToken();
        
        candidtoken = tokenRepo.verifyCandidateByToken(user_token);
        
        trans = transRepo.getRemainingAttempts(candidtoken.getEmail());
        
        if(trans!= null && trans.getAttempts() > 0) {
        	
        	   trans.setAttempts(trans.getAttempts()- 1);
        	
        	   Candidate cand = new Candidate();
               
               cand = candidaterepo.getCandidateByEmail(candidtoken.getEmail());
               
               
               themock.setExam_id("CISA");
               themock.setCandidate_id(cand.getEmail());
               themock.setExam_token(this.generateTokenString(10));
               themock.setStart_date_time(Controls.returnDateTime());
               themock.setCompleted("No");
               themock.setPayment_ref(trans.getReference());
               
               mockRepo.save(themock);
        	
        }else {
        	
        	themock = null;
        }
        
		return themock;
		
	}
	
	


	@Override
	public Mock generateCISAMockResult(List<Question> submittion,  String exam_token){
		
		Mock themock = new Mock();

		HashMap<String,Double> firstScoreMap = new HashMap<String,Double>();
		HashMap<String,Double> secondScoreMap = new HashMap<String,Double>();
		
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
		secondScoreMap = generateSecondScore(firstScoreMap);
		
		//calculate overAllScore for the CISA exam
		overAllScore =  calculateCISAoverAllScore(secondScoreMap);
		
		 themock = storeExamResults( firstScoreMap,  secondScoreMap , overAllScore, exam_token);
		
		return themock;
		
	}
	
	
	
	/** Takes a HashMap of domain scores to calculate the second phase of scores following the domain weight. **/
	public HashMap<String,Double> generateSecondScore(HashMap<String,Double> firstScoreMap){
		
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
	
	
	
	public Double calculateCISAoverAllScore( HashMap<String,Double> secondScoreMap) {
		
		Double overAllScore = 0.0;
		
		overAllScore = secondScoreMap.get(domains[0])+ secondScoreMap.get(domains[1]) + secondScoreMap.get(domains[2])
		               + secondScoreMap.get(domains[3]) + secondScoreMap.get(domains[4]);
		
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
	

	
	
	public Mock storeExamResults(HashMap<String,Double> firstScoreMap, HashMap<String,Double> secondScoreMap ,Double overAllScore,String exam_token) {
		
		Date date = new Date();
		Boolean failed = false;
		
	 
		Mock mockObj = mockRepo.getByToken(exam_token);
		
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
	    
	    
	    List<Domain> db_domains = domainRepo.findDomainsByExam("CISA");
	    
	    // Storing the result per domain
	    for (Domain me : db_domains) {
	    	
	    	ExamResult exam_result = new ExamResult();
	    	exam_result.setExam_token(exam_token);
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
	    	 savedMock = mockRepo.getByToken(exam_token);
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
	public Transaction getAvailableAttempts(String user_token) {
		
		Transaction trans = new Transaction();
        CandidateToken candidtoken = new CandidateToken();
        
        candidtoken = tokenRepo.verifyCandidateByToken(user_token);
        
        if(candidtoken!=null) {
        	
        	trans = transRepo.getRemainingAttempts(candidtoken.getEmail());
        	
        }else {
        	
        	trans = null;
        }
        
        return trans;
		
	}
	
	
	
	
	
}
