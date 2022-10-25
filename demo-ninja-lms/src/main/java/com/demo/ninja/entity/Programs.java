package com.demo.ninja.entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "tbl_lms_program")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Programs {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="program_id",updatable=false, nullable = false)
		private Integer program_id;
		@NotBlank(message = "Program Name is mandatory")
		@Column(unique =true, nullable=false)
		private String program_name;
		private String program_description;
		@Column(nullable=false)
		@NotBlank(message = "Program Status is mandatory")
		private String program_status;
		@Column(nullable=false)
		private Timestamp creation_time;
		@Column(nullable=false)
		private Timestamp last_modified_time;
		/*
		 * @JsonIgnore
		 * 
		 * @OneToMany
		 * 
		 * @JoinColumn(name="batch_program_id") private Set<Batch> batch;
		 * 
		 */


		@Override
		public String toString() {
			return "Programs [program_id=" + program_id + ", program_name=" + program_name + ", program_description="
					+ program_description + ", program_status=" + program_status + ", creation_time=" + creation_time
					+ ", last_modified_time=" + last_modified_time + "]";
		}
		
		
		public Integer getProgram_id() {
			return program_id;
		}
		public void setProgram_id(Integer program_id) {
			this.program_id = program_id;
		}
		public String getProgram_name() {
			return program_name;
		}
		public void setProgram_name(String program_name) {
			this.program_name = program_name;
		}
		public String getProgram_description() {
			return program_description;
		}
		public void setProgram_description(String program_description) {
			this.program_description = program_description;
		}
		public String getProgram_status() {
			return program_status;
		}
		public void setProgram_status(String program_status) {
			this.program_status = program_status;
		}
		public Timestamp getCreation_time() {
			return creation_time;
		}
		public void setCreation_time(Timestamp creation_time) {
			this.creation_time = creation_time;
		}
		public Timestamp getLast_modified_time() {
			return last_modified_time;
		}
		public void setLast_modified_time(Timestamp last_modified_time) {
			this.last_modified_time = last_modified_time;
		}
}