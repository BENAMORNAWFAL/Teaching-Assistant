package com.Project_Manager_ExBR.assignment.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Project_Manager_ExBR.assignment.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
	List<User> findAll();
	User findByIdIs(Long id);
}