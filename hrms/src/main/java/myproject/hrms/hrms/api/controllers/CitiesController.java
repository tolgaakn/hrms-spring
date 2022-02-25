package myproject.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.CityService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping(name = "/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
}
