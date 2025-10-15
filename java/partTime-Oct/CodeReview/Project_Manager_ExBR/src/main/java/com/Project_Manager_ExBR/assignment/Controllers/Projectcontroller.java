package com.Project_Manager_ExBR.assignment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Project_Manager_ExBR.assignment.Models.Project;
import com.Project_Manager_ExBR.assignment.Models.User;
import com.Project_Manager_ExBR.assignment.Services.ProjectService;
import com.Project_Manager_ExBR.assignment.Services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class Projectcontroller {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private ProjectService projectService;
	
	
//	@GetMapping("/dashboard")
//	public String dashboard(HttpSession session, Model model) {
//	 
//		if(session.getAttribute("userId") == null) {
//			return "redirect:/logout";
//		}
//		Long userId = (Long) session.getAttribute("userId");
//		User user = userService.findById(userId);
//		
//		model.addAttribute("user", user);
//		model.addAttribute("unassignedProjects", projectService.getUnassignedProjects(user));
//		model.addAttribute("assignedProjects", projectService.getAssignedProjects(user));
//		 
//		return "dashboard.jsp";
//	}
	
	@RequestMapping("/dashboard/join/{id}")
	public String joinTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectService.findById(id);
		User user = userService.findById(userId);
		
		user.getProjects().add(project);
		userService.updateUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("unassignedProjects", projectService.getUnassignedProjects(user));
		model.addAttribute("assignedProjects", projectService.getAssignedProjects(user));
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard/leave/{id}")
	public String leaveTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectService.findById(id);
		User user = userService.findById(userId);
		
		user.getProjects().remove(project);
		userService.updateUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("unassignedProjects", projectService.getUnassignedProjects(user));
		model.addAttribute("assignedProjects", projectService.getAssignedProjects(user));
		
		return "redirect:/dashboard";
	}

	@GetMapping("/projects/{id}")
	public String viewProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectService.findById(id);
		model.addAttribute("project", project);
		return "view_project.jsp";
	}
	
	@GetMapping("/projects/edit/{id}")
	public String openEditProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectService.findById(id);
		model.addAttribute("project", project);
		return "edit_project.jsp";
	}
	
	@PostMapping("/projects/edit/{id}")
	public String editProject(
			@PathVariable("id") Long id, 
			@Valid @ModelAttribute("project") Project project, 
			BindingResult result, 
			HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userService.findById(userId);
		
		if(result.hasErrors()) {
			return "edit_project.jsp";
		}else {
			Project thisProject = projectService.findById(id);
			project.setUsers(thisProject.getUsers());
			project.setLead(user);
			projectService.updateProject(project);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectService.findById(id);
		projectService.deleteProject(project);
		
		return "redirect:/dashboard";
	}
	
	
	
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("userId", userId);
		return "new_project.jsp";
	}
	
	@PostMapping("/projects/new")
	public String addNewProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		if(result.hasErrors()) {
			return "new_project.jsp";
		}else {
			projectService.addProject(project);
			
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findById(userId);
			user.getProjects().add(project);
			userService.updateUser(user);
			return "redirect:/dashboard";
		}
	}
}
