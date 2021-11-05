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
import com.dashboard.demo.model.Formateur;
import com.dashboard.demo.repository.FormateurRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class FormateurController {
	
	@Autowired
	private FormateurRepository formateurRepository;
	
	@GetMapping("/formateur")
	public List<Formateur> getAllFormateur(){
		return formateurRepository.findAll();
	}
	
	// create Formateur 
		@PostMapping("/formateur")
		public Formateur createFormateur(@RequestBody Formateur formateur) {
			return formateurRepository.save(formateur);
		}
		
		// get Formateur
		@GetMapping("/formateur/{id}")
		public ResponseEntity<Formateur> getFormateurById(@PathVariable Long id) {
			Formateur formateur = formateurRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("formateur non trouvé pour l'id :" + id));
			return ResponseEntity.ok(formateur);
		}
		
		// update Formateur
		
		@PutMapping("/formateur/{id}")
		public ResponseEntity<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateurDetails){
			Formateur formateur = formateurRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("formateur non trouvé pour l'id :" + id));
			
			formateur.setFirstName(formateurDetails.getFirstName());
			formateur.setLastName(formateurDetails.getLastName());
			formateur.setEmailId(formateurDetails.getEmailId());
			formateur.setTelephone(formateurDetails.getTelephone());
			formateur.setDomaine(formateurDetails.getDomaine());
			
			Formateur updatedApprenant = formateurRepository.save(formateur);
			return ResponseEntity.ok(updatedApprenant);
		}
		
		// delete Formateur
		@DeleteMapping("/formateur/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteFormateur(@PathVariable Long id){
			Formateur formateur = formateurRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("formateur not exist with id :" + id));
			
			formateurRepository.delete(formateur);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
