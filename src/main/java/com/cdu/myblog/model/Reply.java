package com.cdu.myblog.model;

import java.sql.Time;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rId;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "boardId")
	private Board board; 
	
	@ManyToOne
	@JoinColumn(name= "userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp CreateDate;
	
}
