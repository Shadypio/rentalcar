package com.car.webapp.service.auto;

import java.util.List;

import com.car.webapp.domain.auto.Auto;

public interface IAutoService {

	List<Auto> getAllAuto();
	
	void insAuto(Auto auto);
	
	void delAuto(String targa);
}
