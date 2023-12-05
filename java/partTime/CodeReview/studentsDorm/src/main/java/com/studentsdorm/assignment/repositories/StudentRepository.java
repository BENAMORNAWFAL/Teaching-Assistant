package com.studentsdorm.assignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studentsdorm.assignment.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findAll();
	List<Student> findByDormId(Long dormId);
}
