package com.thbs.VaccinationService.Entity;

import java.util.List;

public class CitizenInfo {

	Vaccination vaccination;
	List<Citizen> citizens;
	public CitizenInfo(Vaccination vaccination, List<Citizen> citizens) {
		super();
		this.vaccination = vaccination;
		this.citizens = citizens;
	}
	public CitizenInfo() {
		super();
	}
	public Vaccination getVaccination() {
		return vaccination;
	}
	public void setVaccination(Vaccination vaccination) {
		this.vaccination = vaccination;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	
	
}
