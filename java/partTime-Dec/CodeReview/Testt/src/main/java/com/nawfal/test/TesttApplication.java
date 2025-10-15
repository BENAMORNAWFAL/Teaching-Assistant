package com.nawfal.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class TesttApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesttApplication.class, args);
	}
	
	@RequestMapping("/")
	public String home() {
		return "Home.jsp";
	}
	
	
	@RequestMapping("/{operation}/{a}/{b}")
    public String Calculate(@PathVariable("operation") String operation,
    		@PathVariable("a") double a,
    		@PathVariable("b") double b,Model model) {
		
		double result;
		
		switch (operation) {
        case "add":
            result = a + b;
            break;
        case "subtract":
            result = a - b;
            break;
        case "multiply":
            result = a * b;
            break;
        case "divide":
            result = a / b;
            break;
        default:
            return ("Invalid operation: " + operation);
		}
		
		model.addAttribute("operation", operation);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("result", result);
		
		return "Calcul.jsp";
		
	}

}
