package com.ravi.persistencyLayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsRepositary extends CrudRepository<ContactDetails, Integer> {
	
	

}
