// GET ALL, GET ONE

package com.self.spoof.controller;

import java.util.List;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.spoof.model.Developer;
import com.self.spoof.model.Game;
import com.self.spoof.service.DeveloperService;

@RestController
@RequestMapping("/steam_spoof")
public class DeveloperController {

	private DeveloperService developerService;
	
	public DeveloperController(DeveloperService developerService) {
		super();
		this.developerService = developerService;
	}
	
//	@PostMapping("developers")
//	public ResponseEntity<Developer> createDev(@RequestBody Developer developer) {
//		return new ResponseEntity<Developer>(developerService.createDev(developer), HttpStatus.CREATED);
//	}
	
	@GetMapping("developers")
	public List<Developer> getAllDevs() {
		return developerService.getAllDevs();
	}
	
	@GetMapping("developers/{developer_id}/games")
	public List<Game> getAllDevGames(@PathVariable("developer_id") int developerId) {
		return developerService.getAllDevGames(developerId);
	}
}
