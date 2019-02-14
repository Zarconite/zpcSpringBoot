package com.qa.springbootZPC.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springbootZPC.model.*;

@Repository
public interface ZPCRepositoryAccount extends JpaRepository<SpringBootZPCDataModelAccount, Long> {
	//List<SpringBootZPCDataModelParts> findByFilmCategory(String film_Category);
	//List<SpringBootZPCDataModelParts> findByFilmTitle(String filmTitle);
}