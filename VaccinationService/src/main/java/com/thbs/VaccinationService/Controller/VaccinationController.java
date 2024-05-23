package com.thbs.VaccinationService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.thbs.VaccinationService.Entity.Citizen;
import com.thbs.VaccinationService.Entity.CitizenInfo;
import com.thbs.VaccinationService.Entity.Vaccination;
import com.thbs.VaccinationService.Repository.VaccinationRepository;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {
	
	@Autowired
	private VaccinationRepository vaccinationRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
    public ResponseEntity<Vaccination> addCitizen(@RequestBody Vaccination newVaccination) {
        try {
            System.out.println("Received Vaccination: " + newVaccination);

            // Ensure the newCitizen is not null and has valid fields
            if (newVaccination == null || newVaccination.getName() == null || newVaccination.getName().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Vaccination vaccination = vaccinationRepository.save(newVaccination);
            System.out.println("Saved Citizen: " + vaccination);
            return new ResponseEntity<>(vaccination, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/id/{id}")
	public ResponseEntity<CitizenInfo> getCitizenInfo(@PathVariable Integer id){
		CitizenInfo citizenInfo = new CitizenInfo();
		Vaccination vaccination = vaccinationRepository.findById(id).get();
		citizenInfo.setVaccination(vaccination);
		
		//List<Citizen> listOfCitizens = restTemplate.getForObject("http://localhost:8100/citizen/id/"+id, List.class);
		
		List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZENSERVICE/citizen/id/"+id, List.class);
		// we can put above line make sure main class is annotated with load balancer annotation
		citizenInfo.setCitizens(listOfCitizens);
		return new ResponseEntity<>(citizenInfo,HttpStatus.OK);	
	}

}
