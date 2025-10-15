package com.nawfal.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaGoldController {
	
	@RequestMapping("/activities")
	public String activities() {
		return "activities.jsp";
	}
	
	@RequestMapping("/")
	public String index(HttpSession session,
						@RequestParam(value="farm",required=false) String farm,
						@RequestParam(value="cave",required=false) String cave,
						@RequestParam(value="house",required=false) String house,
						@RequestParam(value="quest",required=false) String quest
			) {
		int gold=0;
		ArrayList<String> activities= new ArrayList<String>();
		
		
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", gold);
			
		}else {
			gold=(int) session.getAttribute("gold");
			activities=(ArrayList<String>) session.getAttribute("activities");
		}
		
		SimpleDateFormat date= new SimpleDateFormat("DD MM YYYY h:mm");
		
		
		if(farm != null) {
			int amount=new Random().nextInt(11)+10;
			gold+=amount;
			session.setAttribute("gold", gold);
			activities.add(0,"You entered a farm and earned "+amount+" gold ("+date.format(new Date())+")");
			session.setAttribute("activities", activities);
			return "redirect:/";
		}
		
		if(cave != null) {
			int amount=new Random().nextInt(6)+5;
			gold+=amount;
			session.setAttribute("gold", gold);
			activities.add(0,"You entered a cave and earned "+amount+" gold ("+date.format(new Date())+")");
			session.setAttribute("activities", activities);
			return "redirect:/";
		}
		
		if(house != null) {
			int amount=new Random().nextInt(3)+3;
			gold+=amount;
			session.setAttribute("gold", gold);
			activities.add(0,"You entered a house and earned "+amount+" gold ("+date.format(new Date())+")");
			session.setAttribute("activities", activities);
			return "redirect:/";
		}
		
		if(quest != null) {
			int amount=new Random().nextInt(101)-50;
			
			gold+=amount;
			session.setAttribute("gold", gold);
			if(amount>=0) {
				activities.add(0,"You entered a quest and earned "+amount+" gold ("+date.format(new Date())+")");
				
			}else {
				activities.add(0,"You field a quest and lost "+amount+" gold Ouch. ("+date.format(new Date())+")");
			}
			session.setAttribute("activities", activities);
			return "redirect:/";
		}
		
		return "index.jsp";
	}

}
