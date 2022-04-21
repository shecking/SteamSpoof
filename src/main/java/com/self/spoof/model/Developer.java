package com.self.spoof.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "developers")
public class Developer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String developer_name;
	
	@OneToMany(mappedBy = "developer",
			cascade = {CascadeType.PERSIST,
					   CascadeType.MERGE,
					   CascadeType.DETACH})
	@JsonIgnore
	private List<Game> games;
}
