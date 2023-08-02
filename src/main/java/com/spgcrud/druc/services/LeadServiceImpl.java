package com.spgcrud.druc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spgcrud.druc.entities.Lead;
import com.spgcrud.druc.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;

	@Override
	public List<Lead> listAllLeads() {
		return leadRepository.findAll();
		 
	}

	@Override
	public Lead saveOneLead(Lead lead) {
		return leadRepository.save(lead);
		
	}

	@Override
	public Lead getLeadById(Long id) {
		return leadRepository.findById(id).get();
		
	}

	@Override
	public Lead updateLead(Lead lead) {
		leadRepository.save(lead);
		return null;
	}

	@Override
	public void deleteById(Long id) {
		leadRepository.deleteById(id);
		
	}

	
	
	
}
