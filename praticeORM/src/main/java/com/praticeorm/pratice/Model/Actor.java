package com.praticeorm.pratice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 20)
	private String actorName;
	
	@Column(nullable = false)
	private int birthYear;
	@Column(nullable = false)
	private int height;
	@Column(nullable = false)
	private int weight;
	
	@Column(length = 20)
	private String partner;
	
	@Column(columnDefinition = "TEXT")
	private String image;

}
