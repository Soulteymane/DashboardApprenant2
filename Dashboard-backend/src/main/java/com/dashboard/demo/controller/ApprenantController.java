package com.dashboard.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.demo.exception.ResourceNotFoundException;
import com.dashboard.demo.model.Apprenant;
import com.dashboard.demo.repository.ApprenantRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ApprenantController {
	
	@Autowired
	private ApprenantRepository apprenantRepository;
	
	@GetMapping("/apprenants")
	public List<Apprenant> getAllApprenant(){
		return apprenantRepository.findAll();
	}
	
	// create apprenant 
		@PostMapping("/apprenants")
		public Apprenant createApprenant(@RequestBody Apprenant apprenant) {
			return apprenantRepository.save(apprenant);
		}
		
		// get apprenant
		@GetMapping("/apprenants/{id}")
		public ResponseEntity<Apprenant> getApprenantById(@PathVariable Long id) {
			Apprenant apprenant = apprenantRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("L'apprennant nont trouvé pour l'id :" + id));
			return ResponseEntity.ok(apprenant);
		}
		
		// update apprenant
		
		@PutMapping("/apprenants/{id}")
		public ResponseEntity<Apprenant> updateAppranant(@PathVariable Long id, @RequestBody Apprenant apprenantDetails){
			Apprenant apprenant = apprenantRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("L'apprennant nont trouvé pour l'id :" + id));
			
			apprenant.setFirstName(apprenantDetails.getFirstName());
			apprenant.setLastName(apprenantDetails.getLastName());
			apprenant.setEmailId(apprenantDetails.getEmailId());
			apprenant.setTelephone(apprenantDetails.getTelephone());
			
			Apprenant updatedApprenant = apprenantRepository.save(apprenant);
			return ResponseEntity.ok(updatedApprenant);
		}
		
		// delete apprenant
		@DeleteMapping("/apprenants/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteApprenant(@PathVariable Long id){
			Apprenant apprenant = apprenantRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			apprenantRepository.delete(apprenant);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
