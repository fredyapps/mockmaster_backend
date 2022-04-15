package com.themockmaster.tmmpayment.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.themockmaster.tmmpayment.mockmodels.Mock;


public interface MockRepository  extends JpaRepository<Mock, Integer>  {
	
	@Query(value="SELECT * FROM mocks  WHERE exam_token = ?1", nativeQuery = true)
	Mock getByToken( String exam_token);
	
	@Query(value="SELECT * FROM mocks  WHERE candidate_id = ?1", nativeQuery = true)
	List<Mock> getMocksByCandidate( String candidate_id);

}
