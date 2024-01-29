package com.cdu.myblog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(nullable = false, length = 100) 
	private String title;
	
	@Lob // 대용량 데이터 저장시 사용 ->summer note를 이용한 html 태그도 함께 저장하기 위해
	private String content;
	
	@ColumnDefault("0") // 조회수
	private int cnt; 
	
	@CreationTimestamp
	private Timestamp createTime;
	
	@ManyToOne(fetch = FetchType.EAGER) // Board : Many, User : One -> 한 명의 유저는 여러 개의 게시글을 포함
	@JoinColumn(name = "userId") // FK 연결 후에는 Board가 남아있으면 User 삭제 불가능
	private User user; // 자바는 객체 안에 객체를 저장할 수 있음 / DB는 객체 저장이 불가능하므로 FK를 이용해서 연결
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 는 reply의 부모객체, name은 자식 객체
	private List<Reply> reply;
}
