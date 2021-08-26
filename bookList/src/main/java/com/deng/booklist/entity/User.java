package com.deng.booklist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String email;
	
	@Column(name = "sign_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date signDate;
}
