package com.praticeorm.pratice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@DynamicInsert
@DynamicUpdate
@Entity
@IdClass(RoleId.class)
public class Role {
	@Id
	@Column(name= "movieTitle", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private String movieTitle;
	
	@ManyToOne
	@MapsId
	@JoinColumn(name = "movieTitle",referencedColumnName = "title")
	private Movie movie;
	
	@Id
	@Column(name="actorId", insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private int actorId;
	
	@ManyToOne
	@JoinColumn(name = "actorId", referencedColumnName = "id")
	private Actor Actor;
	
	@Column(length = 2)
	private String category;
	
	@Column(length = 20)
	private String roleName;
}
