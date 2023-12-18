package com.Project_Manager_ExBR.assignment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Project_Manager_ExBR.assignment.Models.LoginUser;
import com.Project_Manager_ExBR.assignment.Models.User;
import com.Project_Manager_ExBR.assignment.Services.ProjectService;
import com.Project_Manager_ExBR.assignment.Services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class UserController {

	// Add once service is implemented:
	@Autowired
	private UserService userServ;
	@Autowired
	private ProjectService projectService;

	// DISPALY ROUTE - forms
	@GetMapping("/")
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "LogReg.jsp";
	}

	

	// ACTION ROUTE - REGISTER
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// TO-DO Later -- call a register method in the service
		// to do some extra validations and create a new user!
		// 1. Execute the Service to Register first
		userServ.register(newUser, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "LogReg.jsp";
		}

		// No errors!
		// Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("user_id", newUser.getId());

		return "redirect:/dashboard";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "LogReg.jsp";
		}

		// No errors!
		// Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("user_id", user.getId());

		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {

		if (session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userServ.findById(userId);

		model.addAttribute("user", user);
		model.addAttribute("unassignedProjects", projectService.getUnassignedProjects(user));
		model.addAttribute("assignedProjects", projectService.getAssignedProjects(user));

		return "dashboard.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();

		return "redirect:/login";
	}

}
