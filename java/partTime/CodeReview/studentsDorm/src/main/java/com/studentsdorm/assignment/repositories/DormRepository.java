package com.studentsdorm.assignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studentsdorm.assignment.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long> {
	List<Dorm> findAll();
}
