package com.self.spoof.service;

import java.util.List;
// import java.util.Set;
import java.util.Set;

import com.self.spoof.model.User;
import com.self.spoof.model.Game;

public interface UserService {
	
	// Create
	User createUser(User user);
	
	// Read All Users
	List<User> getAllUsers();
	// Set<User> getAllUsers();
	
	// Read One User
	User getUserById(int id);
	
	// Read User Games
	// Set<Game> getAllUserGames(int id);
	List<Game> getAllUserGames(int id);
	
	// Update User Info
	User updateUser(User user, int id);
	
	// Update User Games
	Set<Game> updateUserGames(User user, int userId, int gameId);
	
	// Delete
	void deleteUser(int id);
}
