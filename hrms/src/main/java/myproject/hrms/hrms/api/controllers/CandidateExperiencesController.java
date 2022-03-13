package myproject.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.CandidateExperienceService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateExperience;

@RestController
@RequestMapping("/api/candidateExperiences")
public class CandidateExperiencesController {

	private CandidateExperienceService candidateExperienceService;

	@Autowired
	public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
		super();
		this.candidateExperienceService = candidateExperienceService;
	}
	
	@GetMapping("/getByCurriculumVitaeId")
	public DataResult<List<CandidateExperience>> getByCurriculumVitaeId(int curriculumVitaeId){
		return this.candidateExperienceService.getByCurriculumVitaeID(curriculumVitaeId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateExperience candidateExperience) {
		return this.candidateExperienceService.add(candidateExperience);
	}
}
