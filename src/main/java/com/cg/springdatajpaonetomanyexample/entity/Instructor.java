package com.cg.springdatajpaonetomanyexample.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	@Id
    @GeneratedValue(generator = "instr_seq")
	@SequenceGenerator(name="instr_seq",sequenceName = "instr_seq",allocationSize = 1)
	@Column(name="id")
	private long id;

	@Column(name="instr_firstname")
	private String instrFirstName;

	@Column(name="instr_lastname")
	private String instrLastName;
	
	@Column(name="instr_email")
	private String instrEmail;
	
	@OneToMany(mappedBy = "instructor",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Course> courses;

	public Instructor() {
		// TODO Auto-generated constructor stub
	}
	
	public Instructor(String instrFirstName, String instrLastName, String instrEmail) {
		super();
		this.instrFirstName = instrFirstName;
		this.instrLastName = instrLastName;
		this.instrEmail = instrEmail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInstrFirstName() {
		return instrFirstName;
	}

	public void setInstrFirstName(String instrFirstName) {
		this.instrFirstName = instrFirstName;
	}

	public String getInstrLastName() {
		return instrLastName;
	}

	public void setInstrLastName(String instrLastName) {
		this.instrLastName = instrLastName;
	}

	public String getInstrEmail() {
		return instrEmail;
	}

	public void setInstrEmail(String instrEmail) {
		this.instrEmail = instrEmail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
