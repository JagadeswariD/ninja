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

import com.demo.ninja.entity.Batch;
import com.demo.ninja.jpa.BatchRepository;
@RestController 
@RequestMapping("/batch")
public class BatchController {
	@Autowired
	BatchRepository batch_repository;
	
	@GetMapping("/list")
	List<Batch> getAllBatch()
	{
		return batch_repository.findAll(); 
	}
	@GetMapping("/list/{id}")
	Optional<Batch> getAllBatchByID(@PathVariable Integer id)
	{
		return batch_repository.findById(id); 
	}
	
	@PostMapping("/create")
	Batch createBatch(@Valid @RequestBody Batch bt) {
		System.out.println(bt.getBatch_no_of_classes());
		bt.setCreation_time(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		bt.setLast_mod_time(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		
		return batch_repository.save(bt);
	}
	
	@DeleteMapping("/delete/{id}")
	void deleteBatch(@PathVariable int id) {
		System.out.println("id:"+id);
		
		batch_repository.deleteById(id);
	}
	
	@PutMapping("/update")
	void updateProgram(@RequestBody Batch bt){
		System.out.println("update called");
		 batch_repository.updateBatchRepository(bt.getBatch_no_of_classes(),bt.getBatch_description(),bt.getBatch_status(),bt.getBatch_id());
	}
}
