package com.themockmaster.tmmpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.themockmaster.tmmpayment.models.Candidate;
import com.themockmaster.tmmpayment.models.CandidateToken;

public interface TokenRepository extends JpaRepository<CandidateToken, Integer>{

	@Query(value="SELECT * FROM candidate_tokens  WHERE token = ?1", nativeQuery = true)
	CandidateToken verifyCandidateByToken(String token);
	
	
	
	
}
