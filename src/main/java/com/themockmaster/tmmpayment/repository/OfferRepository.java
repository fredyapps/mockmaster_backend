package com.themockmaster.tmmpayment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.themockmaster.tmmpayment.mockmodels.Offers;


public interface OfferRepository extends JpaRepository<Offers, Integer>{
	
	
	@Query(value="SELECT * FROM `packages`  WHERE exam = ?1", nativeQuery = true)
	List<Offers> findPackagesByExam(String exam);
	
	
	@Query(value="SELECT * FROM `packages`  WHERE package_id = ?1", nativeQuery = true)
	Offers findPackageById(Integer package_id);

}
