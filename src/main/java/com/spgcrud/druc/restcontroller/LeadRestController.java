package com.spgcrud.druc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spgcrud.druc.entities.Lead;
import com.spgcrud.druc.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepository;
	
	//http://localhost:9090/api/leads/lists
	@GetMapping("/lists")
	public List<Lead> listAllLeads(){
		return leadRepository.findAll();
		
	}
	//http://localhost:9090/api/leads
	@PostMapping("/save")
	public void saveLead(@RequestBody Lead lead) {
		leadRepository.save(lead);
	}
	
	//http://localhost:9090/api/leads/update
		@PutMapping("/update")
		public void updateLead(@RequestBody Lead lead) {
			leadRepository.save(lead);
		}
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable Long id) {
		leadRepository.deleteById(id);
	}
}
