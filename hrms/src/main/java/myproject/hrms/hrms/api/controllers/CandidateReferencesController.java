package myproject.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.CandidateReferenceService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateReference;

@RestController
@RequestMapping("/api/candidateReferences")
public class CandidateReferencesController {

	private CandidateReferenceService candidateReferenceService;

	@Autowired
	public CandidateReferencesController(CandidateReferenceService candidateReferenceService) {
		super();
		this.candidateReferenceService = candidateReferenceService;
	}
	
	@GetMapping("/getByCurriculumVitae")
	public DataResult<List<CandidateReference>> getByCurriculumVitaeId(int curriculumVitaeId){
		return this.candidateReferenceService.getByCurriculumVitaeId(curriculumVitaeId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateReference candidateReference) {
		return this.candidateReferenceService.add(candidateReference);
	}
}
