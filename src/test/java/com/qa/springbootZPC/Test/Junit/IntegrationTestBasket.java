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

public class IntegrationTestBasket {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ZPCRepositoryBasket ZPCRepositoryBasket;

	// ========== Add a basket to the database ==========
	@Test
	public void addBasketToDatabase() throws Exception{
		mvc.perform(MockMvcRequestBuilders.post("/api/basket")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": 25,\"userId\": 1,\"savedBasket\": \"2,11,32,43,58,94\"}"))
		.andExpect(status()
				.isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.savedBasket", is("2,11,32,43,58,94")));
	}
	
	// ========== Find a basket from database ==========
	@Test
	public void addingAndFindingBasketInDatabase()
	throws Exception {
		ZPCRepositoryBasket.save(new SpringBootZPCDataModelBasket(26, 1,"2,11,32,43,58,94"));
		mvc.perform(get("/api/basket")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].userId",is(1)));
	}
		
	
	// ========== Update a basket in the database ==========
	@Test
	public void updateADatabasePart() throws Exception{
		SpringBootZPCDataModelBasket basket = new SpringBootZPCDataModelBasket(1, 1,"2,11,32,43,58,94");
		ZPCRepositoryBasket.save(basket);
		
		mvc.perform(MockMvcRequestBuilders.put("/api/basket/"+basket.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": 1,\"userId\": 1,\"savedBasket\": \"2,15,32,43,58,96\"}"));
		
		mvc.perform(get("/api/basket/"+basket.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.savedBasket", is("2,15,32,43,58,96")));
	}
	
	// ========== Find one Basket from database ==========
	@Test
	public void findingOneBasketFromDatabase() throws Exception {
		SpringBootZPCDataModelBasket basket = new SpringBootZPCDataModelBasket(1, 1,"35,36,52,71,85,107");
		ZPCRepositoryBasket.save(basket);
		
		mvc.perform(get("/api/basket/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.savedBasket",is("35,36,52,71,85,107")));
	}
	
	// ========== Deleting a basket from database ==========
	@Test
	public void deletingABasketFromDatabase() throws Exception {
		SpringBootZPCDataModelBasket basket = new SpringBootZPCDataModelBasket(1, 2,"5,51,62,73,88,104");
		ZPCRepositoryBasket.save(basket);

		mvc.perform(get("/api/basket/"+basket.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.savedBasket",is("5,51,62,73,88,104")));
		
		mvc.perform(delete("/api/basket/"+basket.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		mvc.perform(get("/api/basket/"+basket.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	// ========== Force resourceNotFound ==========
	@Test
	public void resourceNotFound() throws Exception {
		   try
		   {
			   throw new ResourceNotFoundException("Part","id","Sausages");
		   }
		   catch(ResourceNotFoundException testResourceNotFoundException)
		   {
		      assertEquals("Part not found with id : 'Sausages'", testResourceNotFoundException.getMessage());
		    }
		
	}
	
}
