package com.praticeorm.pratice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Score {
	@Id
	@Column(name= "movieTitle", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private String movieTitle;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="movieTitle")
	private Movie movie;
	
	@ColumnDefault("0")
	private int audience;
	
	@ColumnDefault("0")
	@Column(columnDefinition = "Decimal(65,0)")
	private int sales;
	
}
