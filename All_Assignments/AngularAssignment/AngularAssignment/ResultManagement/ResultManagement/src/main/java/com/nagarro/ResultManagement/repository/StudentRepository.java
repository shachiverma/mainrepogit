package com.nagarro.ResultManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.ResultManagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	
}
