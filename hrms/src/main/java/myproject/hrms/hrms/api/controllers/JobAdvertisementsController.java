package myproject.hrms.hrms.api.controllers;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.JobAdvertisementService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByActive")
	public DataResult<List<JobAdvertisement>> getByActive(){
		return this.jobAdvertisementService.getByActive();
	}
	
	@GetMapping("/getByCreatedDate")
	public DataResult<List<JobAdvertisement>> getByCreatedDate(@RequestParam ZonedDateTime createdDate){
		return this.jobAdvertisementService.getByCreatedDate(createdDate);
	}
	
	@GetMapping("/getByLastDate")
	public DataResult<List<JobAdvertisement>> getByLastDate(@RequestParam ZonedDateTime lastDate){
		return this.jobAdvertisementService.getByLastDate(lastDate);
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(@RequestParam int employerId){
		return this.jobAdvertisementService.getByActiveAndEmployerId(employerId);
	}
	
	@GetMapping("/getJobAdvertisementDetailsById")
	public DataResult<JobAdvertisementDto> getJobAdvertisementDetailsById(int advertisementId){
		return this.jobAdvertisementService.getById(advertisementId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
}
