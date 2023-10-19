package com.spgcrud.druc.restcontroller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spgcrud.druc.dto.LeadDto;
import com.spgcrud.druc.dto.LeadResponse;
import com.spgcrud.druc.entities.Lead;
import com.spgcrud.druc.entities.Post;
import com.spgcrud.druc.repositories.LeadRepository;
import com.spgcrud.druc.services.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	
	
	
	@Autowired
	private LeadService leadService;
	@Autowired
	private LeadRepository leadRepository;
	
	//http://localhost:9090/api/leads
	@GetMapping
	public LeadResponse listAllLeads(@RequestParam(value ="pageNum",defaultValue = "0",required = false)int pageNum,@RequestParam
			(value="pageSize",defaultValue = "5",required = false)int pageSize,@RequestParam(value="sortBy",defaultValue ="id",required = false) String sortBy){
		
		
		return leadService.listAllLeads(pageNum,pageSize,sortBy);
	}
	//http://localhost:9090/api/leads/save
	@PostMapping("/save")
	public ResponseEntity<LeadDto> createPost(@RequestBody LeadDto leadData) {
		
		return new ResponseEntity<>(leadService.createPost(leadData),HttpStatus.CREATED );
		 
	}
	
	//http://localhost:9090/api/leads/update
		@PutMapping("/update")
		public void updateLead(@RequestBody Lead lead) {
			leadRepository.save(lead);
		}
		//springinitialiser
		
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable Long id) {
		leadRepository.deleteById(id);
	}
	
	//http://localhost:9090/api/leads/post
	@GetMapping("/post")
	public List<Post> getAllList() {
		return leadService.getAllList();
		
	}
	
	//http://localhost:9090/api/leads/lead/1
	@RequestMapping("/lead/{id}")
	public String getLead(@PathVariable long id) {
		
		Lead one = leadService.getOne(id);
		 return "one";
		
	}
	
	//http://localhost:9090/api/leads/1
	@GetMapping("/{id}")
	public ResponseEntity<LeadDto> getOneLead(@PathVariable Long id){
		return ResponseEntity.ok(leadService.getOneLead(id));
		
	}
}
