package com.car.webapp.service.utente;

import java.util.List;

import com.car.webapp.domain.utente.Utente;

public interface IUtenteService {

	List <Utente> getAllUtenti();
	
	Utente selUtenteById(Long id);
	
	Utente selUtenteByUsername(String username);

	void insUtente(Utente utente);
	
	void salvaAdminUser(String password);
	
	void modificaUtente(Utente utente);
	
	void disabilitaUtente(Utente utente);
	
	void abilitaUtente(Utente utente);

}
