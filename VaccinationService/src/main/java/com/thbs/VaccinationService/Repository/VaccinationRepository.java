package com.thbs.VaccinationService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thbs.VaccinationService.Entity.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {
  
}

