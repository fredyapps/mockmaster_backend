package com.themockmaster.tmmpayment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.themockmaster.tmmpayment.mockmodels.OffersItems;

public interface OffersItemsRepository extends JpaRepository<OffersItems, Integer>{

	
	@Query(value="SELECT * FROM `package_items`  WHERE package_id = ?1", nativeQuery = true)
	List<OffersItems> findItemsByPackage(Integer package_id);
	
}
