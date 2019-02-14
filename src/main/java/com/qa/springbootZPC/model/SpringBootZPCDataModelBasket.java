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
@Table(name="savedlists")
@EntityListeners(AuditingEntityListener.class)
public class SpringBootZPCDataModelBasket implements Serializable{
	
	@Id
	@Column(name = "basket_ID") long id;
	@Column(name = "users_userID") long userId;
	@Column(name = "savedBaskets") private String savedBasket;
	


	public SpringBootZPCDataModelBasket(long id, long userId, String savedBasket) {
		super();
		this.id = id;
		this.userId = userId;
		this.savedBasket = savedBasket;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getSavedBasket() {
		return savedBasket;
	}



	public void setSavedBasket(String savedBasket) {
		this.savedBasket = savedBasket;
	}



	public SpringBootZPCDataModelBasket() {}
	
}



