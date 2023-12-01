package com.ninjagold.assignment.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaGolds {
	
	@RequestMapping("/activities")
	public String activities() {
		return "activities.jsp";
	}

	@RequestMapping("/")
	public String index(HttpSession session,
			@RequestParam(value="farm", required=false) String farm,
			@RequestParam(value="cave", required=false) String cave,
			@RequestParam(value="house", required=false) String house,
			@RequestParam(value="quest", required=false) String quest
			) {
		
		int gold=0;
		ArrayList<String> activities= new ArrayList<String>();
		
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold",gold);
			session.setAttribute("activities", activities);
		}else {
			gold=(int) session.getAttribute("gold");
			activities= (ArrayList<String>) session.getAttribute("activities");
		}
		
		SimpleDateFormat simpleFormat= new SimpleDateFormat("MMMM DD Y h:mm");
		
		if(farm != null) {
			int amount= new Random().nextInt(11)+10;
			gold+=amount;
			activities.add(0,"You entered a farm and earned "+amount+" gold ("+simpleFormat.format(new Date())+")");
			Date date= new Date();
			session.setAttribute("date", date);
			session.setAttribute("gold",gold);
			session.setAttribute("activities",activities);
			return "redirect:/";
		}
		if(cave != null) {
			int amount= new Random().nextInt(6)+5;
			gold+=amount;
			activities.add(0,"You entered a farm and earned "+amount+" gold ("+simpleFormat.format(new Date())+")");
			Date date= new Date();
			session.setAttribute("date", date);
			session.setAttribute("gold",gold);
			session.setAttribute("activities",activities);
			return "redirect:/";
		}
		if(house != null) {
			int amount= new Random().nextInt(3)+3;
			gold+=amount;
			activities.add(0,"You entered a farm and earned "+amount+" gold ("+simpleFormat.format(new Date())+")");
			Date date= new Date();
			session.setAttribute("date", date);
			session.setAttribute("gold",gold);
			session.setAttribute("activities",activities);
			return "redirect:/";
		}
		
		if(quest != null) {
			int amount= new Random().nextInt(51);
			gold+=amount;
			
			activities.add(0,"You entered a farm and earned "+amount+" gold ("+simpleFormat.format(new Date())+")");
			Date datequest= new Date();
			session.setAttribute("gold",gold);
			session.setAttribute("activities",activities);
			int date1=datequest.getMinutes();
			
			return "redirect:/";
		}
		
		return "index.jsp";
	}
	
	
	
	
}
