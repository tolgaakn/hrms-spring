package myproject.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.CandidateEducationService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/candidateEducations")
public class CandidateEducationsController {

	private CandidateEducationService candidateEducationService;

	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@GetMapping("/getByCurriculumVitaeId")
	public DataResult<List<CandidateEducation>> getByCurriculumVitaeId(int curriculumVitaeId){
		return this.candidateEducationService.getByCurriculumVitaeId(curriculumVitaeId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateEducation candidateEducation) {
		return this.candidateEducationService.add(candidateEducation);
	}
}
