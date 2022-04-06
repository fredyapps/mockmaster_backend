package com.themockmaster.tmmpayment.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.themockmaster.tmmpayment.mockmodels.Mock;


public interface MockRepository  extends JpaRepository<Mock, Integer>  {
	
	@Query(value="SELECT * FROM mocks  WHERE exam_token = ?1", nativeQuery = true)
	Mock getByToken( String exam_token);

}
