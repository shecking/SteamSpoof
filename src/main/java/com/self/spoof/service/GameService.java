package com.self.spoof.service;

import java.util.List;

import com.self.spoof.model.Game;
import com.self.spoof.model.User;

public interface GameService {

//	// Create
//	Game createGame(Game game);
	
	// Read
	List<Game> getAllGames();
	
	// Read One
	Game getGameById(int id);
	
	// Read Game Users
	List<User> getAllGameUsers(int id);
	
//	//Update
//	Game updateGame(Game game, int id);
	
//	//Delete
//	void deleteGame(int id);
	
}
