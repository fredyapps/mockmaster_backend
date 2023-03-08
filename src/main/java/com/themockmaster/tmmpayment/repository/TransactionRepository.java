package com.themockmaster.tmmpayment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.themockmaster.tmmpayment.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
	
	@Query(value="SELECT * FROM tmmpayment  WHERE  transaction_id=?1", nativeQuery = true)
	Transaction findTransactionByReference(String reference);
	
	
	@Query(value="SELECT * FROM tmmpayment  WHERE  reference=?1", nativeQuery = true)
	Transaction findTransactionByInternalReference(String reference);
	
	
	@Query(value="SELECT * FROM tmmpayment  WHERE (completed='Yes' AND attempts > 0 AND email=?1)", nativeQuery = true)
	List<Transaction> getRemainingAttempts(String email);
	
	
	@Query(value="SELECT * FROM tmmpayment  WHERE (completed='Yes' AND attempts > 0 AND email=?1 AND description=?2)", nativeQuery = true)
	List<Transaction> getRemainingAttemptsPerExam(String email,String examid);
	
	
	@Query(value="SELECT * FROM tmmpayment  WHERE (completed='Yes' AND email=?1)", nativeQuery = true)
	Transaction getUserPayments(String email);
	
	
}
