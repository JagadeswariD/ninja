package com.demo.ninja.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.ninja.entity.Programs;

@Repository
public interface ProgramRepository extends JpaRepository<Programs, Integer> {

	@Transactional
	@Modifying
	@Query(value="update tbl_lms_program  set program_status = :status, program_description= :description, last_mod_time=CURRENT_TIMESTAMP where program_name=:name", nativeQuery = true )
	void updateProgramRepository(@Param("name") String name, @Param("status") String status, @Param("description") String desc);
	
	
}