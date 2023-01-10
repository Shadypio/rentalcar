package com.car.webapp.service.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.webapp.dao.IAutoDao;
import com.car.webapp.domain.auto.Auto;

@Service
public class AutoServiceImpl implements IAutoService {

	@Autowired
	IAutoDao autoRepository;
	
	@Override
	public List<Auto> getAllAuto() {

		return autoRepository.selTutti();
	}

	@Override
	public void insAuto(Auto auto) {
		
		autoRepository.salva(auto);
		
	}

	@Override
	public void delAuto(String targa) {
		
		autoRepository.elimina(autoRepository.selByTarga(targa));
		
	}

	@Override
	public Auto getAutoFromTarga(String targa) {
		
		return autoRepository.selByTarga(targa);
	}

	@Override
	public void modificaAuto(Auto auto) {
		
		autoRepository.aggiorna(auto);
		
	}

	@Override
	public void delAutoById(String targa) {
		
		autoRepository.eliminaById(targa);
		
	}

}
