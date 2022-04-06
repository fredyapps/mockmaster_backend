package com.themockmaster.tmmpayment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.themockmaster.tmmpayment.mockmodels.ExamResult;



public interface ExamResultRepository  extends JpaRepository<ExamResult, Integer>{
	
	@Query(value="SELECT * FROM exam_results  WHERE exam_token = ?1", nativeQuery = true)
	List<ExamResult> getByExam( String exam_token);

}
