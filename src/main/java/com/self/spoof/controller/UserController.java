// POST, GET ALL, GET ONE, GET USER GAMES, UPDATE USER, UPDATE USER GAMES, DELETE USER

// HOW TO UPDATE USER GAMES

package com.self.spoof.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.spoof.model.Game;
import com.self.spoof.model.User;
import com.self.spoof.service.UserService;

@RestController
@RequestMapping("/steam_spoof")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("users/{user_id}")
	public ResponseEntity<User> getUserById(@PathVariable("user_id") int userId) {
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("users/{user_id}/games")
	public List<Game> getAllUserGames(@PathVariable("user_id") int userId) {
		return userService.getAllUserGames(userId);
	}
	
	@PutMapping("users/{user_id}")
	public ResponseEntity<User> updateUserPut(@PathVariable("user_id") int userId, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
	}
	
	@PutMapping("users/{user_id}/games/{game_id}")
	public List<Game> updateUserGames(@PathVariable("user_id") int userId, @PathVariable("game_id") int gameId, @RequestBody User user) {
		Set<Game> gameSet = userService.updateUserGames(user, userId, gameId);
		List<Game> gameList = new ArrayList<>(gameSet);
		return gameList;
	}
	
	@DeleteMapping("users/{user_id}")
	public ResponseEntity<String> deleteUser(@PathVariable("user_id") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User " +  userId + " was deleted", HttpStatus.OK);
	}
}
