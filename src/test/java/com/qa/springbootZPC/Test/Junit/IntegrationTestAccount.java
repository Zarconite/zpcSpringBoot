package com.qa.springbootZPC.Test.Junit;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springbootZPC.SpringBootZPCApplication;
import com.qa.springbootZPC.controller.SpringBootZPCController;
import com.qa.springbootZPC.exception.ResourceNotFoundException;
import com.qa.springbootZPC.model.*;
import com.qa.springbootZPC.repositories.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootZPCApplication.class})
//ContextConfiguration(classes = SpringBootGarageApplication.class)
@AutoConfigureMockMvc

public class IntegrationTestAccount {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ZPCRepositoryAccount ZPCRepositoryAccount;
		
	// ========== Add an account to the database ==========
	@Test
	public void addPartToDatabase() throws Exception{
		mvc.perform(MockMvcRequestBuilders.post("/api/account")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": 25,\"username\": \"evensteven\",\"userEmailAddress\": \"even@steven.com\",\"userPassWord\": \"stev0\"}"))
		.andExpect(status()
				.isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.userPassWord", is("stev0")));
	}
	
	// ========== Find an account from database ==========
	@Test
	public void addingAndFindingPartInDatabase()
	throws Exception {
		ZPCRepositoryAccount.save(new SpringBootZPCDataModelAccount(2, "dantheman", "dan@the.man", "password",false));
		mvc.perform(get("/api/account")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[1].username",is("dantheman")));
	}
	
	// ========== Update an account in the database ==========
	@Test
	public void updateADatabaseAccount() throws Exception{
		SpringBootZPCDataModelAccount account = new SpringBootZPCDataModelAccount(3, "spamtheman", "spam@the.man", "pas5word",false);
		ZPCRepositoryAccount.save(account);
		
		mvc.perform(MockMvcRequestBuilders.put("/api/account/"+account.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": 25,\"username\": \"evensteven\",\"userEmailAddress\": \"even@steven.com\",\"userPassWord\": \"stev0\"}"));
		
		mvc.perform(get("/api/account/"+account.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.username", is("evensteven")));
	}

	// ========== Find one account from database ==========
	@Test
	public void findingOneAccountFromDatabase() throws Exception {
		
		ZPCRepositoryAccount.save(new SpringBootZPCDataModelAccount(1, "dantheman", "dan@the.man", "password",false));
		
		mvc.perform(get("/api/account/1")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content()
		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.username",is("dantheman")));
	}
	
	// ========== Deleting an account from database ==========
	@Test
	public void deletingAnAccountFromDatabase() throws Exception {
		SpringBootZPCDataModelAccount account = new SpringBootZPCDataModelAccount(2, "dantheman", "dan@the.man", "password",false);
		ZPCRepositoryAccount.save(account);

		mvc.perform(get("/api/account/"+account.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.userEmailAddress",is("dan@the.man")));
		
		mvc.perform(delete("/api/account/"+account.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		mvc.perform(get("/api/account/"+account.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	// ========== Force resourceNotFound ==========
	@Test
	public void resourceNotFound() throws Exception {
		   try
		   {
			   throw new ResourceNotFoundException("Account","id","Sausages");
		   }
		   catch(ResourceNotFoundException testResourceNotFoundException)
		   {
		      assertEquals("Account not found with id : 'Sausages'", testResourceNotFoundException.getMessage());
		    }
		
	}
	
}
