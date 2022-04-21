package com.self.spoof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.self.spoof.model.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer>{

}
