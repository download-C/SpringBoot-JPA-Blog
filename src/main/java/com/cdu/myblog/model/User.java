package com.cdu.myblog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class User {
 
	@Id	// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 증가
	private int id;	
	
	@Column(nullable = false, length = 30)	// 아이디
	private String username; 
	
	@Column(nullable = false, length = 100) // 나중에 단방향 암호화로 변경할 예정
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // User 생성 시 기본 역할은 user로 저장
	
	@CreationTimestamp
	private Timestamp createDate;
}
