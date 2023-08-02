package com.spgcrud.druc.services;

import java.util.List;

import com.spgcrud.druc.entities.Lead;

public interface LeadService {

	List<Lead> listAllLeads();

	Lead saveOneLead(Lead lead);
	
	Lead getLeadById(Long id);
	
	Lead updateLead(Lead lead);
	
	void deleteById(Long id);
}
