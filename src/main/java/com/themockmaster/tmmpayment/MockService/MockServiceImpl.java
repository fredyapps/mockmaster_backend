package com.themockmaster.tmmpayment.mockservice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themockmaster.tmmpayment.mockmodels.ExamResult;
import com.themockmaster.tmmpayment.mockmodels.Mock;
import com.themockmaster.tmmpayment.mockmodels.Question;
import com.themockmaster.tmmpayment.repository.ExamResultRepository;
import com.themockmaster.tmmpayment.repository.MockRepository;
import com.themockmaster.tmmpayment.repository.OptionRepository;
import com.themockmaster.tmmpayment.repository.QuestionRepository;

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
	
	
	private  String[] domains = {"CISA_DOM1", "CISA_DOM2", "CISA_DOM3", "CISA_DOM4", "CISA_DOM5"};
	
	
	@Override
	public List<Question> createCISAMockExam(){
		
		List<Question> questions = new ArrayList<Question>();
		
		List<Question> dom1questions = questionRepo.pull_cisa_dom1_questions(domains[0],31);
		List<Question> dom2questions = questionRepo.pull_cisa_dom1_questions(domains[1],25);
		List<Question> dom3questions = questionRepo.pull_cisa_dom1_questions(domains[2],18);
		List<Question> dom4questions = questionRepo.pull_cisa_dom1_questions(domains[3],35);
		List<Question> dom5questions = questionRepo.pull_cisa_dom1_questions(domains[4],41);
		
		
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
	        
	        
		return questions;
		
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
		
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
		          +"lmnopqrstuvwxyz!@#$%&";
		
				Random rnd = new Random();
				StringBuilder sb = new StringBuilder(len);
				for (int i = 0; i < len; i++)
					sb.append(chars.charAt(rnd.nextInt(chars.length())));
				return sb.toString();
				
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
	    
	    
	    // Storing the result per domain
	    for (String me : domains) {
	    	
	    	ExamResult exam_result = new ExamResult();
	    	exam_result.setExam_token(exam_token);
	  	    exam_result.setExam_id(savedMock.getMockId());
	  	    exam_result.setDomain_id(me);
	  	
	  	    int fscore = (int) Math.round(firstScoreMap.get(me));
	  	    int sscore = (int) Math.round(secondScoreMap.get(me));
	  	    if(fscore < 450) { failed = true;}
	  	    exam_result.setFirst_score(String.valueOf(fscore));
	  	    exam_result.setSecond_score(String.valueOf(sscore));
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
	
	
	
	
	
}
