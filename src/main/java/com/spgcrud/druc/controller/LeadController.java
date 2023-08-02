package com.spgcrud.druc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spgcrud.druc.entities.Lead;
import com.spgcrud.druc.services.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	//http://localhost:9090/login
	@GetMapping("/login")
	public String view() {
		
		return "login";
	}
	//http://localhost:9090/listleads
	@GetMapping("/listleads")
	public String listLeads(Model model) {
		model.addAttribute("listleads", leadService.listAllLeads());
		return "leads";
		
	}
	
	@GetMapping("/new")
	public String createLeadForm(Model model) {
		Lead lead=new Lead();
		model.addAttribute("lead", lead);
		return "create_lead";
	}
	
	@PostMapping("/leads")
	public String saveLead(@ModelAttribute("lead") Lead lead) {
		leadService.saveOneLead(lead);
		return "redirect:/listleads";
	}
	
	@GetMapping("/leads/edit/{id}")
	public String editLeadForm(@PathVariable Long id ,Model model) {
model.addAttribute("lead", leadService.getLeadById(id));
		return"edit_lead";
	}
	
	@PostMapping("/leads/{id}")
	public String updateLead(@PathVariable Long id, @ModelAttribute("l") Lead lead ,Model model) {
		Lead leadByID = leadService.getLeadById(id);
		
		leadByID.setEmail("email");
		leadByID.setPassword(lead.getPassword());
		leadByID.setConfirmPassword(lead.getConfirmPassword());
		leadByID.setDateOfBirth(lead.getDateOfBirth());
		leadByID.setCountry(lead.getCountry());
		leadService.updateLead(leadByID);
		return "redirect:/listleads";
	} 
	
	
	@GetMapping("/leads/delete/{id}")
	public String deleteLead(@PathVariable Long id,Model model) {
		model.addAttribute("lead",leadService.getLeadById(id));
		return "delete_lead";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteOneLead(@PathVariable Long id) {
		leadService.deleteById(id);
		return "redirect:/listleads";
	}

}
