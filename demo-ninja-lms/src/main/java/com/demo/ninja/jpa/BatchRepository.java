package com.demo.ninja.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.ninja.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer>{
	@Transactional
	@Modifying
	@Query(value="update tbl_lms_batch  set batch_no_of_classes = :num, batch_description= :description, last_mod_time=CURRENT_TIMESTAMP, batch_status=:status where batch_id=:id", nativeQuery = true )

	void updateBatchRepository(@Param("num") Integer no_of_classes,@Param("description") String description,@Param("status") String status,@Param("id") Integer id);

	@Modifying
	@Query(value="DELETE FROM tbl_lms_batch  WHERE batch_id= :num and batch_program_id=(select batch_program_id from tbl_lms_batch where batch_id=:num)",nativeQuery = true)
	void deleteById(@Param("num")Integer id);
	
	@Modifying
	@Query(value="DELETE FROM tbl_lms_batch  WHERE batch_id= :num ",nativeQuery = true)
	void deleteById1(@Param("num")Integer id);
}
