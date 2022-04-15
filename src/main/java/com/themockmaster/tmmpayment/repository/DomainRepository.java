package com.themockmaster.tmmpayment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.themockmaster.tmmpayment.mockmodels.Domain;


public interface DomainRepository extends JpaRepository<Domain, String>{ 

	@Query(value="SELECT * FROM `domain`  WHERE exam_code = ?1", nativeQuery = true)
	List<Domain> findDomainsByExam(String examCode);
	
}
