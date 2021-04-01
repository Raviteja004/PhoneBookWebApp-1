package com.ravi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.ravi.persistencyLayer.ContactDetails;
import com.ravi.service.ContactInformationService;

@Controller
public class ContactOperationsController {
	
	private ContactInformationService service;
	public ContactOperationsController(ContactInformationService service) {
	this.service=service;
	}
	
	@GetMapping("/edit")
	public String editContact( @RequestParam("cid") Integer contactId, Model model)
	{
		ContactDetails contactByIdobj = service.getContactById(contactId);
		 model.addAttribute("contact", contactByIdobj);
		return "contact";
		
	}

	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model)
	{
		
		Boolean isdelete = service.DeleteContactById(contactId);
		
		if(isdelete)
		{
			model.addAttribute("SuccMessage", "Contact Delete Successfully");
		}
		else
		{
			model.addAttribute("FailMessage", "Contact Delete not success");
		}
		return "redirect:view-contacts";
		
	}
}
