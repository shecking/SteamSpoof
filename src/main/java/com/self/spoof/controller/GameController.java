// GET ALL, GET ONE, GET GAME USERS

package com.self.spoof.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.spoof.model.Game;
import com.self.spoof.model.User;
import com.self.spoof.service.GameService;

@RestController
@RequestMapping("/steam_spoof")
public class GameController {

	private GameService gameService;
	
	public GameController(GameService gameService) {
		super();
		this.gameService = gameService;
	}
	
//	@PostMapping("games")
//	public ResponseEntity<Game> createGame(@RequestBody Game game) {
//		return new ResponseEntity<Game>(gameService.createGame(game), HttpStatus.CREATED);
//	}
	
	@GetMapping("games")
	public List<Game> getAllGames() {
		return gameService.getAllGames();
	}
	
	@GetMapping("games/{game_id}")
	public ResponseEntity<Game> getGameById(@PathVariable("game_id") int gameId) {
		return new ResponseEntity<Game>(gameService.getGameById(gameId), HttpStatus.OK);
	}
	
	@GetMapping("games/{game_id}/users")
	public List<User> getAllGameUsers(@PathVariable("game_id") int gameId) {
		return gameService.getAllGameUsers(gameId);
	}
	
//	@PutMapping("games/{game_id}")
//	public ResponseEntity<Game> updateGame(@PathVariable("game_id") int gameId, @RequestBody Game game) {
//		return new ResponseEntity<Game>(gameService.updateGame(game, gameId), HttpStatus.OK);
//	}
//	
//	@DeleteMapping("games/{game_id}")
//	public ResponseEntity<String> deleteGame(@PathVariable("game_id") int gameId) {
//		gameService.deleteGame(gameId);
//		return new ResponseEntity<String>("Game " +  gameId + " was deleted", HttpStatus.OK);
//	}
	
	
}
