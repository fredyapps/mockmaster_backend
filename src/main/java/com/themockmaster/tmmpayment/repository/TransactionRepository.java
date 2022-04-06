package com.themockmaster.tmmpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.themockmaster.tmmpayment.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
	Transaction findByReference(String reference);
	
	
}
