package com.self.spoof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.spoof.exception.ResourceNotFoundException;
import com.self.spoof.model.Developer;
import com.self.spoof.model.Game;
import com.self.spoof.repository.DeveloperRepository;
import com.self.spoof.service.DeveloperService;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	private DeveloperRepository developerRepository;
	
	@Autowired
	public DeveloperServiceImpl(DeveloperRepository developerRepository) {
		super();
		this.developerRepository = developerRepository;
	}

	// CREATE DEV
//	@Override
//	public Developer createDev(Developer developer) {
//		return developerRepository.save(developer);
//	}
	
	// READ DEVS
	@Override
	public List<Developer> getAllDevs() {
		return developerRepository.findAll();
	}
	
	// READ ALL DEV GAMES
	@Override
	public List<Game> getAllDevGames(int id) {
		Developer currentDev = developerRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Developer", "id", id) );
		return currentDev.getGames();
	}

}
