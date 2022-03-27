package myproject.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.JobTypeService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.entities.concretes.JobType;

@RestController
@RequestMapping("/api/jobtypes")
@CrossOrigin
public class JobTypesController {

	private JobTypeService jobTypeService;

	@Autowired
	public JobTypesController(JobTypeService jobTypeService) {
		super();
		this.jobTypeService = jobTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobType>> getAll(){
		return this.jobTypeService.getAll();
	}
}
