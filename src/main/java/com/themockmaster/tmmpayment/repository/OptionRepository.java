package com.themockmaster.tmmpayment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.themockmaster.tmmpayment.mockmodels.Option;
import com.themockmaster.tmmpayment.mockmodels.Question;



public interface OptionRepository  extends JpaRepository<Option, Long> {
	
	@Query(value="SELECT * FROM `option`  WHERE question_id = ?1", nativeQuery = true)
	List<Option> findOptionsByquestion(Integer questionId);

}
