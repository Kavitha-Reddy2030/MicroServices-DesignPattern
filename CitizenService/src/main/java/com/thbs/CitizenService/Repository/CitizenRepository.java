package com.thbs.CitizenService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thbs.CitizenService.Entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    List<Citizen> findByVaccinationCenterId(Integer vaccinationCenterId);
}
