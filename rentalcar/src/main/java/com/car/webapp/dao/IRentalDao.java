package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.prenotazione.Rental;
import com.car.webapp.domain.utente.Customer;

public interface IRentalDao {

	List<Rental> doRetrieveAll();
	
	Rental doRetrieveById(Long id);
	
	Rental doRetrieveByCustomer(Customer customer);
	
	void doSave(Rental rental);
	
	void doUpdate(Rental rental);
	
	void doDelete(Rental rental);
}
