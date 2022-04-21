package com.self.spoof.model;

// import java.util.ArrayList;
import java.util.HashSet;
// import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String profile_name;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private int age;
	@Column
	private String country;
	@Column
	private double wallet;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,
						   CascadeType.MERGE,
						   CascadeType.DETACH})
	@JoinTable(
			name = "user_games",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "game_id"))
	@JsonIgnore
	private Set<Game> games = new HashSet<Game>();
	// private List<Game> games = new ArrayList<>();
}
