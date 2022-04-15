package com.themockmaster.tmmpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.themockmaster.tmmpayment.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
	Transaction findByReference(String reference);
	
	
	@Query(value="SELECT * FROM tmmpayment  WHERE (completed='Yes' AND attempts > 0 AND email=?1)", nativeQuery = true)
	Transaction getRemainingAttempts(String email);
	
	
}
