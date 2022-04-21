package com.self.spoof.service.impl;

// import java.util.ArrayList;
import java.util.List;
// import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.spoof.exception.ResourceNotFoundException;
import com.self.spoof.model.Game;
import com.self.spoof.model.User;
import com.self.spoof.repository.GameRepository;
import com.self.spoof.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	private GameRepository gameRepository;
	
	@Autowired
	public GameServiceImpl(GameRepository gameRepository) {
		super();
		this.gameRepository = gameRepository;
	}
	
//	// CREATE (save)
//	@Override
//	public Game createGame(Game game) {
//		return gameRepository.save(game);
//	}

	// READ ALL
	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

	// READ ONE
	@Override
	public Game getGameById(int id) {
		return gameRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Game", "id", id) );
	}
	
	// READ ALL GAME USERS ORIGINAL
	@Override
	public List<User> getAllGameUsers(int id) {
		Game currentGame = gameRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Game", "id", id) );
		return currentGame.getUsers();
		
	}
	
	// UPDATE
//	@Override
//	public Game updateGame(Game game, int id) {
//		Game existingGame = gameRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Game", "id", id) );
//		
//		existingGame.setCopies_sold(game.getCopies_sold());
//		// existingGame.setDeveloper_id(game.getDeveloper_id());
//		existingGame.setGame_name(game.getGame_name());;
//		existingGame.setPrice(game.getPrice());
//		
//		gameRepository.save(existingGame);
//		
//		return existingGame;
//	}
	
	// DELETE
//	@Override
//	public void deleteGame(int id) {
//		Game existingGame = gameRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Game", "id", id) );
//		
//		gameRepository.deleteById(id);
//	}
}
