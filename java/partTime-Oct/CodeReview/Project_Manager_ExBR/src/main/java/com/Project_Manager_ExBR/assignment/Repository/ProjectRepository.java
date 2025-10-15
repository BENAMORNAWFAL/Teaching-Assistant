package com.Project_Manager_ExBR.assignment.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Project_Manager_ExBR.assignment.Models.Project;
import com.Project_Manager_ExBR.assignment.Models.User;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	Project findByIdIs(Long id);
	List<Project> findAllByUsers(User user);
	List<Project> findByUsersNotContains(User user);
}
