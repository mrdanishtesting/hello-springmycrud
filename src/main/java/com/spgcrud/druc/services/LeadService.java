package com.spgcrud.druc.services;

import java.util.List;
import java.util.Optional;

import com.spgcrud.druc.dto.CommentDto;
import com.spgcrud.druc.dto.LeadDto;
import com.spgcrud.druc.dto.LeadResponse;
import com.spgcrud.druc.entities.Lead;

public interface LeadService {

	LeadResponse listAllLeads(int pageNum,int pageSize,String sortBy);

	Lead saveOneLead(Lead lead);
	
	Lead getLeadById(Long id);
	
	Lead updateLead(Lead lead);
	
	void deleteById(Long id);

	Optional<Lead> getOneLead(long id);//rest controller

	List getAllList();

	Lead getOne(long id);


LeadDto createPost(LeadDto leadData);
LeadDto getOneLead(Long id);


}
