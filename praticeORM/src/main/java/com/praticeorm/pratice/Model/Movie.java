package com.praticeorm.pratice.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Movie {
	
	@Id
	@Column(nullable = false, length = 30)
	private String title;
	
	@Column(columnDefinition = "date")
	private Timestamp relaseDate;
	
	@Column(nullable = false)
	@ColumnDefault(value = "0.0")
	private float starScore;
	@Column(length = 10)
	private String genre;
	@Column(columnDefinition = "TEXT")
	private String img;
}
