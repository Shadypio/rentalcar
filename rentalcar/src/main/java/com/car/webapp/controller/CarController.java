package com.car.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.webapp.config.security.SpringSecurityUserContext;
import com.car.webapp.domain.auto.Car;
import com.car.webapp.service.auto.ICarService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private ICarService carService;
	
	private List<Car> recordset;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCars(Model model) {
		
		recordset = carService.getAllCars();
		
		model.addAttribute("head", "Ricerca Auto");
		model.addAttribute("subheading", "Ricerca tutte le auto");
		model.addAttribute("cars", recordset);
		model.addAttribute("isCar", true);
		if (recordset != null)
			model.addAttribute("carsAmount", recordset.size());
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "cars";
	}
	
	@GetMapping(value = "/delete/{licensePlate}")
	public String deleteCar(@PathVariable("licensePlate") String licensePlate, Model model)
	{
		try
		{
			if (licensePlate.length() > 0)
			{
				carService.deleteCar(carService.getCarByLicensePlate(licensePlate));
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione auto", ex);
			
		}

		return "redirect:/car/";
	}
	
	
	
	@GetMapping(value = "/detailscar/{licensePlate}")
	public String viewCarDetails(@PathVariable("licensePlate") String licensePlate, Model model)
	{
		
		Car car = carService.getCarByLicensePlate(licensePlate);
		
		model.addAttribute("head", "Dettagli Auto");
		model.addAttribute("subheading", "Targa " + licensePlate);
		model.addAttribute("car", car);
		model.addAttribute("isAuto", true);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "detailsCar";
	}
	
	
	@GetMapping(value = "/add")
	public String addCar(Model model) {
		
		Car car = new Car();
		
		model.addAttribute("head", "Inserimento Nuova Auto");
		model.addAttribute("car", car);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		
		return "insertCar";
	}
	
	@PostMapping(value = "/add")
	public String manageAddCar(@Valid @ModelAttribute("car") Car newCar, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "insertCar";
		}
		
		carService.insertCar(newCar);
		
		redirectAttributes.addFlashAttribute("saved", true);
		
		return "redirect:/car/detailscar/" + newCar.getLicensePlate();
	}
	

}
