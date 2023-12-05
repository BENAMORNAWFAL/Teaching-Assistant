package com.studentsdorm.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.studentsdorm.assignment.models.Student;
import com.studentsdorm.assignment.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	
	// Create Method
		public Student addStudent(Student student) {
			return studentRepo.save(student);
		}
		
		public List<Student> allStudents(){
			return studentRepo.findAll();
		}
		
		public Student findStudent(Long id) {
			Optional<Student> oneStudent=studentRepo.findById(id);
			if(oneStudent.isPresent()) {
				return oneStudent.get();
			}
			return null;
		}
		
		public List<Student> studentsDorm(Long dorm_id){
			List<Student> AllStudents=studentRepo.findByDormId(dorm_id);
			if (AllStudents.isEmpty()) {
				return null;
			}else {
				return AllStudents;
			}
		}
		
		public void removeFromDorm(Student student) {
			student.setDorm(null);
			studentRepo.save(student);
		}
		
		
		
		
}
