package myproject.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.CandidateCoverLetterService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateCoverLetter;

@RestController
@RequestMapping("/api/candidateCoverLetters")
public class CandidateCoverLettersController {

	private CandidateCoverLetterService candidateCoverLetterService;

	@Autowired
	public CandidateCoverLettersController(CandidateCoverLetterService candidateCoverLetterService) {
		super();
		this.candidateCoverLetterService = candidateCoverLetterService;
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<CandidateCoverLetter>> getByCandidateId(int candidateId){
		return this.candidateCoverLetterService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCoverLetter candidateCoverLetter) {
		return this.candidateCoverLetterService.add(candidateCoverLetter);
	}
}
