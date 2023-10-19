package com.spgcrud.druc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spgcrud.druc.dto.LeadDto;
import com.spgcrud.druc.dto.LeadResponse;
import com.spgcrud.druc.entities.Lead;
import com.spgcrud.druc.entities.Post;
import com.spgcrud.druc.exception.ResourceNotFoundException;
import com.spgcrud.druc.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;

	@Override
	public LeadResponse listAllLeads(int pageNum,int pageSize,String sortBy) {
		Pageable pageable = PageRequest.of(pageNum, pageSize,Sort.by(sortBy));
		    Page<Lead> leads = leadRepository.findAll(pageable);
		    List<Lead> content = leads.getContent();
		    	List<LeadDto> contents = content.stream().map(a->mapToleadData(a)).collect(Collectors.toList());
		    	LeadResponse response=new LeadResponse();
		       response.setContent(contents);
		       response.setPageNum(pageable.getPageNumber());
		       response.setPageSize(pageable.getPageSize());
		      // response.setTotalElements();
		    	return response;
	}

	@Override
	public Lead saveOneLead(Lead lead) {
		return leadRepository.save(null);
		
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

	List<Post> list;
	
	public LeadServiceImpl() {
		
		list=new ArrayList<>();
		list.add(new Post(1,"danish","danish"));
		list.add(new Post(2,"arun","arun"));
	}
	
//	@Override
//	public Optional<Lead> getOneLead(long id) {
//		
//		Optional<Lead> lead = leadRepository.findById(id);
//		return lead;
//		
//		
//	}

	@Override
	public List<Post> getAllList() {
		return list;
	}

@Override
public Optional<Lead> getOneLead(long id) {
	
	return Optional.empty();
}

@Override
public Lead getOne(long id) {
	Optional<Lead> lead = leadRepository.findById(id);
	  return  lead.get();
}

@Override
public LeadDto createPost(LeadDto leadData) {
	Lead lead = mapToEntity(leadData);
	
	Lead dto = leadRepository.save(lead);
return	mapToleadData(dto);
	
	
}

public Lead mapToEntity(LeadDto leadData) {
	Lead lead=new Lead();
	lead.setEmail(leadData.getEmail());
	lead.setPassword(leadData.getPassword());
	lead.setConfirmPassword(leadData.getConfirmPassword());
	lead.setDateOfBirth(leadData.getDateOfBirth());
	lead.setCountry(leadData.getCountry());
	return lead;
	
}

public LeadDto mapToleadData(Lead lead) {
	LeadDto leadData=new LeadDto();
	leadData.setId(lead.getId());
	
	leadData.setEmail(lead.getEmail());
	leadData.setPassword(lead.getPassword());
	leadData.setConfirmPassword(lead.getConfirmPassword());
	leadData.setDateOfBirth(lead.getDateOfBirth());
	leadData.setCountry(lead.getCountry());
	return leadData;
	
}

@Override
public LeadDto getOneLead(Long id) {
	
 // Lead lead =leadRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
	Optional<Lead> findById = leadRepository.findById(id);

	   System.out.println(":before get:"+findById);
        Lead lead = findById.get();
        lead.getEmail();
        System.out.println("leadobject"+lead);
 LeadDto leadDto = mapToleadData(lead);
	 System.out.println("dtoobject"+leadDto);
	 return leadDto;
	
}

	
	
	
}
