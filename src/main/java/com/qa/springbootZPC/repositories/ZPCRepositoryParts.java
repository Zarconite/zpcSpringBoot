package com.qa.springbootZPC.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springbootZPC.model.*;

@Repository
public interface ZPCRepositoryParts extends JpaRepository<SpringBootZPCDataModelParts, Long> {
	List<SpringBootZPCDataModelParts> findByPartName(String partName);
	//List<SpringBootZPCDataModelParts> findByFilmTitle(String filmTitle);
}