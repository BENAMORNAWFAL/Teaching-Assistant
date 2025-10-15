package com.lookify.group1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lookify.group1.Models.Song;
import com.lookify.group1.Repositories.SongRepository;

@Service
public class SongService {
	
	
	//adding the song repositry as a dependency
	@Autowired
	private SongRepository SongRep;
	
	//************** Create Song *************
	public Song createsong(Song s) {
		return SongRep.save(s);
	}
	//************** Read Song *************
	         // Read one
	public Song findsong(Long id) {
		Optional<Song> optionalSong= SongRep.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
			
		}else {
			return null;
		}
	}
			// Read All
	public List<Song> findAllSong(){
		return SongRep.findAll();
	}
	//************** update Song *************
	public Song updateSong(Song s) {
		return SongRep.save(s);
	}
	
	//************** Delete Song *************
	
	public void deleteSong(Long id) {
		SongRep.deleteById(id);
	}
	
	// ************* top ten ************
	public List<Song> topTen() {
		return SongRep.getTopTen();
	}
}
