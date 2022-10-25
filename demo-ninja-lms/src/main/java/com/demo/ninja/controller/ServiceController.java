package com.demo.ninja.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ninja.entity.Programs;
import com.demo.ninja.jpa.ProgramRepository;

@RestController 
@RequestMapping("/")
public class ServiceController {
	@Autowired
	ProgramRepository program_repository;
	
	@GetMapping("/program/list")
	List<Programs> getAllPrograms()
	{
		return program_repository.findAll(); 
	}
	
	@PostMapping("/program/create")
	Programs createProgram(@Valid @RequestBody Programs program){
		System.out.println("create called");
		program.setCreation_time(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		program.setLast_modified_time(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		 return program_repository.saveAndFlush(program);
	}

	@PutMapping("/program/update")
	void updateProgram(@RequestBody Programs program){
		System.out.println("update called");
		 program_repository.updateProgramRepository(program.getProgram_name(),program.getProgram_status(), program.getProgram_description());
		 
	}
	
	@DeleteMapping("/program/delete/{id}")
	void deleteProgram(@PathVariable Integer id) {
		System.out.println("delete called");
		 program_repository.deleteById(id);
	}
	
}