package com.nizar.loginregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nizar.loginregistration.models.LoginUser;
import com.nizar.loginregistration.models.User;
import com.nizar.loginregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {

	// Add once service is implemented:
	@Autowired
	private UserService userServ;

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
		return "login.jsp";
	}

	@GetMapping("/home")
	public String home(Model model, HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/login";
		} else {
			User user = userServ.findById(userId);
			model.addAttribute("user", user);
			return "home.jsp";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

//		session.setAttribute("userId", null);

		session.invalidate();
		

		return "redirect:/login";
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
			return "login.jsp";
		}

		// No errors!
		// Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("user_id", newUser.getId());

		return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}

		// No errors!
		// Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("user_id", user.getId());

		return "redirect:/home";
	}

}
