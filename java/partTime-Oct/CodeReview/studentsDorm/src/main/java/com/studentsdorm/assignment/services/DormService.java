package com.studentsdorm.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsdorm.assignment.models.Dorm;
import com.studentsdorm.assignment.repositories.DormRepository;

@Service
public class DormService {
	
	@Autowired
	private DormRepository dormRepo;
	
	
	
	
	// Create Method
	public Dorm addDorm(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	public List<Dorm> allDorms(){
		return dormRepo.findAll();
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> oneDorm=dormRepo.findById(id);
		if(oneDorm.isPresent()) {
			return oneDorm.get();
		}
		return null;
	}
	
}
