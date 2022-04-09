package com.themockmaster.tmmpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.themockmaster.tmmpayment.models.Candidate;



public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

	@Query(value="SELECT * FROM candidates  WHERE token = ?1", nativeQuery = true)
	Candidate getCandidateByToken( String candidate_token);
	
	@Query(value="SELECT * FROM candidates  WHERE email = ?1", nativeQuery = true)
	Candidate getCandidateByEmail( String email);
	
}
