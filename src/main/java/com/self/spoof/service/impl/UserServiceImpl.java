package com.self.spoof.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.spoof.exception.ResourceNotFoundException;
import com.self.spoof.model.Game;
import com.self.spoof.model.User;
import com.self.spoof.repository.UserRepository;
import com.self.spoof.repository.GameRepository;
import com.self.spoof.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private GameRepository gameRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository) {
		super();
		this.userRepository = userRepository;
		this.gameRepository = gameRepository;
	}

	// CREATE USER
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	// READ ALL USERS
 	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// READ ONE USER
	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User", "id", id) );
	}
	
	// READ ALL USER GAMES
	@Override
	public List<Game> getAllUserGames(int id) {
		User currentUser = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User", "id", id) );
		Set<Game> userGamesSet = currentUser.getGames();
		List<Game> userGamesList = new ArrayList<>(userGamesSet);
		return userGamesList;
	}
	
	// UPDATE USER INFO
	@Override
	public User updateUser(User user, int id) {
		User existingUser = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User", "id", id));
		
		existingUser.setAge(user.getAge());
		existingUser.setCountry(user.getCountry());
		existingUser.setFirst_name(user.getFirst_name());
		existingUser.setLast_name(user.getLast_name());
		existingUser.setProfile_name(user.getProfile_name());
		existingUser.setWallet(user.getWallet());
		
		userRepository.save(existingUser);
		
		return existingUser;
	}

	// UPDATE USER GAMES
	@Override
	public Set<Game> updateUserGames(User user, int userId, int gameId) {
		User existingUser = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User", "id", userId));
		Game existingGame = gameRepository.findById(gameId).orElseThrow( () -> new ResourceNotFoundException("Game", "id", userId));
		
		Set<Game> userGames = existingUser.getGames();
		
		userGames.add(existingGame);
		existingUser.setGames(userGames);
		
		userRepository.save(existingUser);
		
		return existingUser.getGames();
	}

	// DELETE
	@Override
	public void deleteUser(int id) {
		User existingUser = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User", "id", id));
		
		userRepository.deleteById(id);
	}

}
