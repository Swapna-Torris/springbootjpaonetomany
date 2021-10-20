package com.cg.springdatajpaonetomanyexample.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="course")
public class Course {
	@Id
    @GeneratedValue(generator = "course_seq")
	@SequenceGenerator(name="course_seq",sequenceName = "course_seq",allocationSize = 1)
	@Column(name="id")
	private long id;
	
	@Column(name="course_title")
	private String courseTitle;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="instructor_id")
	//@JsonBackReference
	private Instructor instructor;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String courseTitle, Instructor instructor) {
		super();
		this.courseTitle = courseTitle;
		this.instructor = instructor;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + id + ", courseTitle=" + courseTitle + ", instructor=" + instructor + "]";
	}
	
	
}
