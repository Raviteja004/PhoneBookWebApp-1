package com.ravi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ravi.persistencyLayer.ContactDetails;
import com.ravi.service.ContactInformationService;

@Controller
public class ContactInfoController {

	private ContactInformationService service;

	public ContactInfoController(ContactInformationService service) {
		this.service = service;
	}

	@GetMapping("/load-form")
	public String loadForm(Model model) {
		ContactDetails cobj = new ContactDetails();

		// sending data from controller to ui
		model.addAttribute("contact", cobj);

		// returning logical view name
		return "contact";
	}

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") ContactDetails contact, Model model) {
		boolean isSaved = service.saveOrUpdateContacts(contact);
		System.out.println("hello handle submit::" + isSaved);
		if (isSaved) {
			model.addAttribute("succMsg", "Contact Saved");
		} else {
			model.addAttribute("failMsg", "Failed to save contact");
		}

		return "contact";
	}

	@GetMapping("/view-contacts")
	public String handleViewContactHyperlink(Model model) {
		List<ContactDetails> allcontactsObj = service.DisplayContactsInfo();
		System.out.println("allcontactsObj==>" + allcontactsObj);
		model.addAttribute("contacts", allcontactsObj);
		return "allcontacts-display";
	}
}
