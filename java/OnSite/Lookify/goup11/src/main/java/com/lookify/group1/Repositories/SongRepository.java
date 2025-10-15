package com.lookify.group1.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lookify.group1.Models.Song;


@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
	List<Song> findAll();
	
	@Query(value="SELECT * FROM songs ", nativeQuery= true)
	List<Song> getTopTen();
}
