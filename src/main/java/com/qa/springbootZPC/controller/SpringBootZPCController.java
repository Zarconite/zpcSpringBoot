package com.qa.springbootZPC.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.qa.springbootZPC.exception.ResourceNotFoundException;
import com.qa.springbootZPC.model.*;
import com.qa.springbootZPC.repositories.*;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class SpringBootZPCController {

	@Autowired
	ZPCRepositoryParts ZPCRepositoryParts;
	
	@Autowired
	ZPCRepositoryAccount ZPCRepositoryAccount;
	
	@Autowired
	ZPCRepositoryBasket ZPCRepositoryBasket;

	@PostMapping("/account")
	public SpringBootZPCDataModelAccount createAccount(@Valid @RequestBody SpringBootZPCDataModelAccount mSDM) {
	return ZPCRepositoryAccount.save(mSDM);
	}
	
	@PostMapping("/basket")
	public SpringBootZPCDataModelBasket createBasket(@Valid @RequestBody SpringBootZPCDataModelBasket mSDM) {
	return ZPCRepositoryBasket.save(mSDM);
	}
	
	@PostMapping("/parts")
	public SpringBootZPCDataModelParts createPart(@Valid @RequestBody SpringBootZPCDataModelParts mSDM) {
	return ZPCRepositoryParts.save(mSDM);
	}
/*		//create an (x)
	@PostMapping("/category")
	public SpringBootBlockBusterDataModelCategory createCategory(@Valid @RequestBody SpringBootBlockBusterDataModelCategory mSDM) {
	return categoryRepository.save(mSDM);
}
	@PostMapping("/filmlist")
	public SpringBootBlockBusterDataModelFilmList createFilmList(@Valid @RequestBody SpringBootBlockBusterDataModelFilmList mSDM) {
	return filmListRepository.save(mSDM);
}*/
	
	//get an (x)
	@GetMapping("/basket/{id}")
	public SpringBootZPCDataModelBasket getBasketId(@PathVariable("id") long id) {
		return ZPCRepositoryBasket.findById(id).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelBasket","id",id));		
	}
	
	@GetMapping("/account/{id}")
	public SpringBootZPCDataModelAccount getAccountId(@PathVariable("id") long id) {
		return ZPCRepositoryAccount.findById(id).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelAccount","id",id));		
	}
	
	@GetMapping("/parts/{id}")
	public SpringBootZPCDataModelParts getPartId(@PathVariable("id") long id) {
		return ZPCRepositoryParts.findById(id).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelParts","id",id));		
	}
	
	@GetMapping("/partname/{partName}")
	public List<SpringBootZPCDataModelParts> getPartName(@PathVariable("partName") String partName) {
		
		if(ZPCRepositoryParts.findByPartName(partName) == null) {
		throw new ResourceNotFoundException("SpringBootZPCDataModelParts","partName",partName);	
		}
		return ZPCRepositoryParts.findByPartName(partName);
	}
	
	//get all (x)
	@GetMapping("/account")
	public List<SpringBootZPCDataModelAccount> getAllAccounts(){
		return ZPCRepositoryAccount.findAll();
	}
	
	@GetMapping("/parts")
	public List<SpringBootZPCDataModelParts> getAllParts(){
		return ZPCRepositoryParts.findAll();
	}
	
	@GetMapping("/basket")
	public List<SpringBootZPCDataModelBasket> getAllBaskets(){
		return ZPCRepositoryBasket.findAll();
	}

	//update an (x)
	@PutMapping("/account/{id}")
	public SpringBootZPCDataModelAccount updateAccount(@PathVariable("id") Long id,
			@Valid @RequestBody SpringBootZPCDataModelAccount savedAccount) {
		SpringBootZPCDataModelAccount mSDM = ZPCRepositoryAccount.findById(id).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelAccount","savedAccount",savedAccount));
		
		mSDM.setUserEmailAddress(savedAccount.getUserEmailAddress());
		mSDM.setUsername(savedAccount.getUsername());
		mSDM.setUserPassWord(savedAccount.getUserPassWord());
		
		SpringBootZPCDataModelAccount updateData = ZPCRepositoryAccount.save(mSDM);
		return updateData;
	}
	
	@PutMapping("/basket/{id}")
	public SpringBootZPCDataModelBasket updateBasket(@PathVariable("id") Long id,
			@Valid @RequestBody SpringBootZPCDataModelBasket savedBasket) {
		SpringBootZPCDataModelBasket mSDM = ZPCRepositoryBasket.findById(id).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelBasket","savedBasket",savedBasket));
		
		mSDM.setSavedBasket(savedBasket.getSavedBasket());
		
		SpringBootZPCDataModelBasket updateData = ZPCRepositoryBasket.save(mSDM);
		return updateData;
	}
	
	@PutMapping("/parts/{id}")
	public SpringBootZPCDataModelParts updatePart(@PathVariable("id") Long id,
			@Valid @RequestBody SpringBootZPCDataModelParts partData) {
		SpringBootZPCDataModelParts mSDM = ZPCRepositoryParts.findById(id).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelParts","partData",partData));
		
		mSDM.setPartId(partData.getPartId());
	    mSDM.setPartBrand(partData.getPartBrand());
	  	mSDM.setPartModel(partData.getPartModel());
	  	mSDM.setPartName(partData.getPartName());
		mSDM.setPartCompatibilityOutputs(partData.getPartCompatibilityOutputs());
		mSDM.setPartCompatibilityInputs(partData.getPartCompatibilityInputs());
	    mSDM.setPartOverclockable(partData.getPartOverclockable());
	   	mSDM.setPartExtra(partData.getPartExtra());
	  	mSDM.setPartClock(partData.getPartClock());
	  	mSDM.setPartBoost(partData.getPartBoost());
	  	mSDM.setPartPrice(partData.getPartPrice());
	  	mSDM.setPartWattage(partData.getPartWattage());
	  	mSDM.setPartDescription(partData.getPartDescription());
	  	mSDM.setPartStock(partData.getPartStock());
		
		SpringBootZPCDataModelParts updateData = ZPCRepositoryParts.save(mSDM);
		return updateData;
	}
	
	//remove an (x)
	@DeleteMapping("/basket/{id}")
	public ResponseEntity<?> deleteBasket(@PathVariable("id") Long basketID){
		SpringBootZPCDataModelBasket mSDM = ZPCRepositoryBasket.findById(basketID).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelBasket","basketId",basketID));
		
		ZPCRepositoryBasket.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") Long accountID){
		SpringBootZPCDataModelAccount mSDM = ZPCRepositoryAccount.findById(accountID).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelAccount","accountID",accountID));
		
		ZPCRepositoryAccount.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/parts/{id}")
	public ResponseEntity<?> deletePart(@PathVariable("id") Long partID){
		SpringBootZPCDataModelParts mSDM = ZPCRepositoryParts.findById(partID).orElseThrow(()->new ResourceNotFoundException("SpringBootZPCDataModelParts","partID",partID));
		
		ZPCRepositoryParts.delete(mSDM);
		return ResponseEntity.ok().build();
		
	}
	
}
