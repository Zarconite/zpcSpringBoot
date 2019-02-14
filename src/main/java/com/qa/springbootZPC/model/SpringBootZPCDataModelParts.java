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
@Table(name="parts")
@EntityListeners(AuditingEntityListener.class)
public class SpringBootZPCDataModelParts implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "db_id") long id;
	@Column(name = "part_id") private String partId;
	@Column(name = "part_brand") private String partBrand;
	@Column(name = "part_model") private String partModel;
	@Column(name = "part_name") private String partName;
	@Column(name = "part_compatibility_outputs") private String partCompatibilityOutputs;
	@Column(name = "part_compatibility_inputs") private String partCompatibilityInputs;
	@Column(name = "part_overclockable") private Boolean partOverclockable;
	@Column(name = "part_extra") private String partExtra;
	@Column(name = "part_clock") private String partClock;
	@Column(name = "part_clock_boost") private String partBoost;
	@Column(name = "part_price") private Double partPrice;
	@Column(name = "part_wattage") private int partWattage;
	@Column(name = "part_description") private String partDescription;
	@Column(name = "part_stock") private int partStock;
	
	public SpringBootZPCDataModelParts(long id, String partId, String partBrand,
			String partModel, String partName, String partCompatibilityOutputs, String partCompatibilityInputs,
			Boolean partOverclockable, String partExtra, String partClock, String partBoost, Double partPrice,
			int partWattage, String partDescription, int partStock) {
		this.id = id;
		this.partId = partId;
		this.partBrand = partBrand;
		this.partModel = partModel;
		this.partName = partName;
		this.partCompatibilityOutputs = partCompatibilityOutputs;
		this.partCompatibilityInputs = partCompatibilityInputs;
		this.partOverclockable = partOverclockable;
		this.partExtra = partExtra;
		this.partClock = partClock;
		this.partBoost = partBoost;
		this.partPrice = partPrice;
		this.partWattage = partWattage;
		this.partDescription = partDescription;
		this.partStock = partStock;
	}
	
	
	public int getPartStock() {
		return partStock;
	}



	public void setPartStock(int partStock) {
		this.partStock = partStock;
	}

	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getPartId() {
		return partId;
	}



	public void setPartId(String partId) {
		this.partId = partId;
	}



	public String getPartBrand() {
		return partBrand;
	}



	public void setPartBrand(String partBrand) {
		this.partBrand = partBrand;
	}



	public String getPartModel() {
		return partModel;
	}



	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}



	public String getPartName() {
		return partName;
	}



	public void setPartName(String partName) {
		this.partName = partName;
	}



	public String getPartCompatibilityOutputs() {
		return partCompatibilityOutputs;
	}



	public void setPartCompatibilityOutputs(String partCompatibilityOutputs) {
		this.partCompatibilityOutputs = partCompatibilityOutputs;
	}



	public String getPartCompatibilityInputs() {
		return partCompatibilityInputs;
	}



	public void setPartCompatibilityInputs(String partCompatibilityInputs) {
		this.partCompatibilityInputs = partCompatibilityInputs;
	}



	public Boolean getPartOverclockable() {
		return partOverclockable;
	}



	public void setPartOverclockable(Boolean partOverclockable) {
		this.partOverclockable = partOverclockable;
	}



	public String getPartExtra() {
		return partExtra;
	}



	public void setPartExtra(String partExtra) {
		this.partExtra = partExtra;
	}



	public String getPartClock() {
		return partClock;
	}



	public void setPartClock(String partClock) {
		this.partClock = partClock;
	}



	public String getPartBoost() {
		return partBoost;
	}



	public void setPartBoost(String partBoost) {
		this.partBoost = partBoost;
	}



	public Double getPartPrice() {
		return partPrice;
	}



	public void setPartPrice(Double partPrice) {
		this.partPrice = partPrice;
	}



	public int getPartWattage() {
		return partWattage;
	}



	public void setPartWattage(int partWattage) {
		this.partWattage = partWattage;
	}



	public String getPartDescription() {
		return partDescription;
	}



	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}



	public SpringBootZPCDataModelParts() {}
	
}



