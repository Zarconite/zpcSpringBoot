package com.qa.springbootZPC.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)
public class SpringBootZPCDataModelAccount implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userID") long id;
	@NotBlank
	@Column(name = "userName") private String username;
	@NotBlank
	@Column(name = "userEmail") private String userEmailAddress;
	@NotBlank
	@Column(name = "userPassword") private String userPassWord;
	@Column(name = "isAdmin") private Boolean isAdmin;
	

	
	public SpringBootZPCDataModelAccount(long id, @NotBlank String username, String userEmailAddress,
			String userPassWord, Boolean isAdmin) {
		this.id = id;
		this.username = username;
		this.userEmailAddress = userEmailAddress;
		this.userPassWord = userPassWord;
		this.isAdmin = isAdmin;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}



	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUserEmailAddress() {
		return userEmailAddress;
	}



	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}



	public String getUserPassWord() {
		return userPassWord;
	}



	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}



	public SpringBootZPCDataModelAccount() {}
	
}



