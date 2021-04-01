package com.ravi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ravi.persistencyLayer.ContactDetails;
import com.ravi.persistencyLayer.ContactDetailsRepositary;
@Component
public class ContactInformationServiceImpl implements ContactInformationService{

	ContactDetailsRepositary repositary;
	
	public ContactInformationServiceImpl(ContactDetailsRepositary repositary) {
            this.repositary=repositary;
	}
	
	@Override
	public Boolean saveOrUpdateContacts(ContactDetails contactdtls) {
		ContactDetails savedObj = repositary.save(contactdtls);
		return savedObj.getContactId()!=null;
		
	}

	@Override
	public Boolean DeleteContactById(Integer id) {
		Boolean isDeleted =false;
		try {
			repositary.deleteById(id);
			isDeleted= true;
		    }
		catch(Exception e){
			e.printStackTrace();
			isDeleted= false;
		  }
		return isDeleted;
		}
		
	

	@Override
	public List<ContactDetails> DisplayContactsInfo() {
		/*
		 * List<ContactDetails> findAll = (List<ContactDetails>) repositary.findAll();
		 * return findAll;
		 */
		return (List<ContactDetails>) repositary.findAll();
	}

	@Override
	public ContactDetails getContactById(Integer id) {
		Optional<ContactDetails> findByIdObj = repositary.findById(id);
		if( findByIdObj.isPresent())
		{
			//ContactDetails dtlsobj = findByIdObj.get();
			return findByIdObj.get();
		}
		return null;
		
		
	}
	

}
