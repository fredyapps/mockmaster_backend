package com.themockmaster.tmmpayment.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.themockmaster.tmmpayment.mockmodels.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	
	@Query(value="SELECT * FROM question  WHERE domain_id= :domainId ORDER BY RAND() limit :number_of_questions", nativeQuery = true)
	List<Question> pull_cisa_questions(
			  @Param("domainId") String domainId, 
			  @Param("number_of_questions") Integer number_of_questions);
	
	
	

}
