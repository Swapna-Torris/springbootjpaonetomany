package com.cg.springdatajpaonetomanyexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springdatajpaonetomanyexample.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
