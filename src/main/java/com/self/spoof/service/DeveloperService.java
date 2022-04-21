package com.self.spoof.service;

import java.util.List;

import com.self.spoof.model.Developer;
import com.self.spoof.model.Game;

public interface DeveloperService {

	// Create
//	Developer createDev(Developer developer);
	
	// Read All
	List<Developer> getAllDevs();
	
	// Read Dev Games
	List <Game> getAllDevGames(int id);
}
