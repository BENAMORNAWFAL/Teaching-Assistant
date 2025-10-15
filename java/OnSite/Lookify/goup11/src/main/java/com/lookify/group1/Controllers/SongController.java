package com.lookify.group1.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lookify.group1.Models.Song;
import com.lookify.group1.Services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {
	@Autowired
	private SongService SongServ;
	
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs=SongServ.findAllSong();
		model.addAttribute("songs", songs);
		return "dash.jsp";
	}
	
	//Render Route
	@GetMapping("/song/new")
	public String newsong(@ModelAttribute("song") Song song) {
			
		return "create.jsp";
	}
	
	// Action route
	@PostMapping("/song/new")
	public String addsong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "create.jsp";
			
		}else {
			SongServ.createsong(song);
			return "redirect:/dashboard";
		}
	}
	
	// Show one Song
	@GetMapping("/song/{id}")
	public String showsong(@PathVariable("id") Long id, Model model) {
		Song song=SongServ.findsong(id);
		model.addAttribute("song", song);
		return "showsong.jsp";
	}
	
	// Delete song
	@DeleteMapping("/song/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		SongServ.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	// Top ten
	@GetMapping("/song/top")
	public String details(Model model) {
		List<Song> songs = SongServ.topTen();
		model.addAttribute("songs", songs);
		return "top.jsp";
	}
}
