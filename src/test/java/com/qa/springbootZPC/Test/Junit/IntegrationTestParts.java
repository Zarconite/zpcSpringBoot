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
import com.qa.springbootZPC.model.SpringBootZPCDataModelParts;
import com.qa.springbootZPC.model.SpringBootZPCDataModelParts;
import com.qa.springbootZPC.repositories.ZPCRepositoryParts;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootZPCApplication.class})
//ContextConfiguration(classes = SpringBootGarageApplication.class)
@AutoConfigureMockMvc

public class IntegrationTestParts {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ZPCRepositoryParts ZPCRepositoryParts;

	// ========== Find a part from database ==========
	@Test
	public void addingAndFindingPartInDatabase()
	throws Exception {
		ZPCRepositoryParts.save(new SpringBootZPCDataModelParts(2, "tes0001","Part","Brand", "name", "", "", false, "", "", "", 99.99, 0, "", 0));
		mvc.perform(get("/api/parts")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].partName",is("name")));
	}
	
	// ========== Find a part from database by name ==========
	@Test
	public void addingAndFindingPartInDatabaseByName()
	throws Exception {
		SpringBootZPCDataModelParts part = new SpringBootZPCDataModelParts(25, "cpu0025","AMD","Ryzen 7", "3850x", "", "", false, "", "", "", 99.99, 0, "", 0);
		ZPCRepositoryParts.save(part);
		
		mvc.perform(get("/api/partname/"+part.getPartName())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].partModel",is("Ryzen 7")));
	}
		
	// ========== Add a part to the database ==========
	@Test
	public void addPartToDatabase() throws Exception{
		mvc.perform(MockMvcRequestBuilders.post("/api/parts")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": 100,\"partId\": \"test001\",\"partBrand\": \"brand\",\"partModel\": \"model\",\"partName\": \"name\",\"partCompatibilityOutputs\": \"USB3\",\"partCompatibilityInputs\": \"ITX\",\"partOverclockable\": false,\"partExtra\": \"200\",\"partClock\": \"\",\"partBoost\": \"\",\"partPrice\": 399.99,\"partWattage\": 0,\"partDescription\": \"\",\"partStock\": 10}"))
		.andExpect(status()
				.isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.partBrand", is("brand")));
	}
	
	// ========== Update a part in the database ==========
	@Test
	public void updateADatabasePart() throws Exception{
		SpringBootZPCDataModelParts part = new SpringBootZPCDataModelParts(1, "tes0003","brandz","modelz", "namez", "", "", false, "", "", "", 99.99, 0, "", 0);
		ZPCRepositoryParts.save(part);
		
		mvc.perform(MockMvcRequestBuilders.put("/api/parts/"+part.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": 1,\"partId\": \"test001\",\"partBrand\": \"brand\",\"partModel\": \"updatedmodel\",\"partName\": \"name\",\"partCompatibilityOutputs\": \"USB3\",\"partCompatibilityInputs\": \"ITX\",\"partOverclockable\": false,\"partExtra\": \"200\",\"partClock\": \"\",\"partBoost\": \"\",\"partPrice\": 399.99,\"partWattage\": 0,\"partDescription\": \"\",\"partStock\": 10}"));
		
		mvc.perform(get("/api/parts/"+part.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.partModel", is("updatedmodel")));
	}

	// ========== Find one part from database ==========
	@Test
	public void findingOneVehicleFromDatabase() throws Exception {
		SpringBootZPCDataModelParts part = new SpringBootZPCDataModelParts(1, "cpu0026","AMD","Ryzen 7", "3820x", "", "", false, "", "", "", 99.99, 0, "", 0);
		ZPCRepositoryParts.save(part);
		
		mvc.perform(get("/api/parts/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.partName",is("3820x")));
	}

	// ========== Deleting a vehicle from database ==========
	@Test
	public void deletingAPartFromDatabase() throws Exception {
		SpringBootZPCDataModelParts part = new SpringBootZPCDataModelParts(3, "tes0003","brandz","modelz", "namez", "", "", false, "", "", "", 99.99, 0, "", 0);
		ZPCRepositoryParts.save(part);

		mvc.perform(get("/api/parts/"+part.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.partBrand",is("brandz")));
		
		mvc.perform(delete("/api/parts/"+part.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		mvc.perform(get("/api/parts/"+part.getId())
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
