package com.thbs.CitizenService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.CitizenService.Entity.Citizen;
import com.thbs.CitizenService.Repository.CitizenRepository;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hello All", HttpStatus.OK);
    }

    @RequestMapping("/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
        try {
            List<Citizen> citizenList = citizenRepository.findByVaccinationCenterId(id);
            return new ResponseEntity<>(citizenList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
        try {
            System.out.println("Received Citizen: " + newCitizen);

            // Ensure the newCitizen is not null and has valid fields
            if (newCitizen == null || newCitizen.getName() == null || newCitizen.getName().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Citizen citizen = citizenRepository.save(newCitizen);
            System.out.println("Saved Citizen: " + citizen);
            return new ResponseEntity<>(citizen, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
