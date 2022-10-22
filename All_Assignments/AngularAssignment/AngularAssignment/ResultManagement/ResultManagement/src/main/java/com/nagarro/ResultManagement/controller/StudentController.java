package com.nagarro.ResultManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ResultManagement.exception.ResourceNotFoundException;
import com.nagarro.ResultManagement.model.Student;
import com.nagarro.ResultManagement.repository.StudentRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private StudentRepository studentrepository;
	
	//get all students
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		return studentrepository.findAll();
	}
	
	//create student restapi
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student st) {
		return studentrepository.save(st);
	}
	
	//get student by roll no. rest api
	@GetMapping("/students/{rollno}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer rollno)
	{
		Student student = studentrepository.findById(rollno)
		.orElseThrow(() -> new ResourceNotFoundException("Student Not Exists With Roll No.:"+ rollno));
		
		return ResponseEntity.ok(student);
	}
	
	//update student rest api
	@PutMapping("/students/{rollno}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer rollno, @RequestBody Student studentdetails)
	{
		Student student = studentrepository.findById(rollno)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Exists With Roll No.:"+ rollno));
		
		student.setName(studentdetails.getName());
		student.setDateofbirth(studentdetails.getDateofbirth());
		student.setScore(studentdetails.getScore());
		//student.setRollno(studentdetails.getRollno());
		
		Student updatedstudent = studentrepository.save(student);
		return ResponseEntity.ok(updatedstudent);
	}
	
	//delete student restapi
	@DeleteMapping("/students/{rollno}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Integer rollno)
	{
		Student student = studentrepository.findById(rollno)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Exists With Roll No.:"+ rollno));
		
		studentrepository.delete(student);
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
