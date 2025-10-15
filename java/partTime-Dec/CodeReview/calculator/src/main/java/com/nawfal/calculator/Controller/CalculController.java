package com.nawfal.calculator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculController {
	
	@RequestMapping("/")
	public String home() {
		return "Home.jsp";
	}
	
	@RequestMapping("/{operation}/{a}/{b}")
	public String Calcul(
			@PathVariable("operation")String operation,
			@PathVariable("a")double a,
			@PathVariable("b")double b,
			Model model
			) {
		
		double result;
		switch(operation) {
		case "add":
			result=a+b;
			break;
		case "subtract":
			result=a-b;
			break;
		case "multiply":
			result=a*b;
			break;
		case "divide":
			result=a/b;
			break;
		default:
			return("Invalid operation :"+ operation);
		}
		
		
		model.addAttribute("operation", operation);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("result", result);
		
		return "Calcul.jsp";
	}
}
