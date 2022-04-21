package com.self.spoof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.self.spoof.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

}
