package com.demo.ninja.entity;

import java.sql.Timestamp;

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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tbl_lms_batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="batch_id",updatable=false, nullable = false, unique=true)
	private Integer batch_id;
	@NotBlank(message = "Batch Name is mandatory")
	@Column(unique =true, nullable=false)
	private String batch_name;
	private String batch_description;
	@Column( nullable=false)
	@NotBlank(message = "Batch Status is mandatory")
	private String batch_status;
	@NotNull(message = "Batch No. of classes is mandatory")
	@Column(nullable=false)
	private Integer batch_no_of_classes;
	@Column(nullable=false)
	private Timestamp creation_time;
	@Column(nullable=false)
	private Timestamp last_mod_time;
	@Column(name="batch_program_id")
	private int batch_program_id;
	
	  @ManyToOne(targetEntity = Programs.class, cascade = CascadeType.ALL)
	  @JoinColumn(name="batch_program_id", referencedColumnName = "program_id", insertable = false, updatable = false)
	  Programs program;
	 
	
	
	
	public Programs getProgram() {
		return program;
	}
	public void setProgram(Programs program) {
		this.program = program;
	}
	public int getBatch_program_id() {
		return batch_program_id;
	}
	public void setBatch_program_id(int batch_program_id) {
		this.batch_program_id = batch_program_id;
	}

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Batch [batch_id=" + batch_id + ", batch_name=" + batch_name + ", batch_description=" + batch_description
				+ ", batch_status=" + batch_status + ", batch_no_of_classes=" + batch_no_of_classes + ", creation_time="
				+ creation_time + ", last_mod_time=" + last_mod_time + ", program=]";
	}
	public Batch(Integer batch_id, String batch_name, String batch_description, String batch_status,
			Integer batch_no_of_classes, Timestamp creation_time, Timestamp last_mod_time, int bt_program_id,Programs program) {
		super();
		this.batch_id = batch_id;
		this.batch_name = batch_name;
		this.batch_description = batch_description;
		this.batch_status = batch_status;
		this.batch_no_of_classes = batch_no_of_classes;
		this.creation_time = creation_time;
		this.last_mod_time = last_mod_time;
		this.batch_program_id = bt_program_id;
		this.program = program;
	}
	public Integer getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(Integer batch_id) {
		this.batch_id = batch_id;
	}
	public String getBatch_name() {
		return batch_name;
	}
	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}
	public String getBatch_description() {
		return batch_description;
	}
	public void setBatch_description(String batch_description) {
		this.batch_description = batch_description;
	}
	public String getBatch_status() {
		return batch_status;
	}
	public void setBatch_status(String batch_status) {
		this.batch_status = batch_status;
	}
	public Integer getBatch_no_of_classes() {
		return batch_no_of_classes;
	}
	public void setBatch_no_of_classes(Integer batch_no_of_classes) {
		this.batch_no_of_classes = batch_no_of_classes;
	}
	public Timestamp getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(Timestamp creation_time) {
		this.creation_time = creation_time;
	}
	public Timestamp getLast_mod_time() {
		return last_mod_time;
	}
	public void setLast_mod_time(Timestamp last_mod_time) {
		this.last_mod_time = last_mod_time;
	}

	
	
}
