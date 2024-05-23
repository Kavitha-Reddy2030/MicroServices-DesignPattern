package com.thbs.VaccinationService.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



public class Citizen {
    
    private Integer id;

   
    private String name;

    
    private Integer vaccinationCenterId;
    
    
    

	public Citizen() {
		super();
	}

	public Citizen(Integer id, String name, Integer vaccinationCenterId) {
		super();
		this.id = id;
		this.name = name;
		this.vaccinationCenterId = vaccinationCenterId;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVaccinationCenterId() {
		return vaccinationCenterId;
	}

	public void setVaccinationCenterId(Integer vaccinationCenterId) {
		this.vaccinationCenterId = vaccinationCenterId;
	}
    
    
}
