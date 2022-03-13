package myproject.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.CandidateProjectService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateProject;

@RestController
@RequestMapping("/api/candidateProjects")
public class CandidateProjectsController {

	private CandidateProjectService candidateProjectService;

	@Autowired
	public CandidateProjectsController(CandidateProjectService candidateProjectService) {
		super();
		this.candidateProjectService = candidateProjectService;
	}
	
	@GetMapping("/getByCurriculumVitae")
	public DataResult<List<CandidateProject>> getByCurriculumVitaeId(int curriculumVitaeId){
		return this.candidateProjectService.getByCurriculumVitaeId(curriculumVitaeId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateProject candidateProject) {
		return this.candidateProjectService.add(candidateProject);
	}
}
