package com.studentsdorm.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentsdorm.assignment.models.Dorm;
import com.studentsdorm.assignment.models.Student;
import com.studentsdorm.assignment.services.DormService;
import com.studentsdorm.assignment.services.StudentService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class StudentsDorm {
	
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private DormService dormService;
	
	
	@GetMapping("/dorms")
	public String index(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "dorms.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "newDorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm,BindingResult result) {
		if(result.hasErrors()) {
			return "newDorm.jsp";
		}
		dormService.addDorm(dorm);
		return "redirect:/dorms";
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "newStudent.jsp";
	}
	
	@PostMapping("/students/new")
	public String addStudent(@ModelAttribute("student") Student student) {
		System.out.println(student.getDorm().getName());
		studentService.addStudent(student);
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms/{id}")
	public String viewDorms(@PathVariable("id") Long id, Model model,HttpSession session) {
		
		model.addAttribute("dorm", dormService.findDorm(id));
		model.addAttribute("students", studentService.studentsDorm(id));
		return "viewDorm.jsp";
	}
	
	@GetMapping("/students/remove/{id}")
	public String removeStudent(@PathVariable("id") Long id, HttpSession session) {
		studentService.removeFromDorm(studentService.findStudent(id));
		
		return "redirect:/dorms";
	}
	
	
}
