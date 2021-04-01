package com.ravi.service;

import java.util.List;

import com.ravi.persistencyLayer.ContactDetails;

public interface ContactInformationService {

	public Boolean saveOrUpdateContacts(ContactDetails contactdtls);

	public Boolean DeleteContactById(Integer id);

	public List<ContactDetails> DisplayContactsInfo();

	public ContactDetails getContactById(Integer id);

}
