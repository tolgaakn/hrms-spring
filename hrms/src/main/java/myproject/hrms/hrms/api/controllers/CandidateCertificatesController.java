package myproject.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.CandidateCertificateService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateCertificate;

@RestController
@RequestMapping("/api/candidateCertificates")
public class CandidateCertificatesController {

	private CandidateCertificateService candidateCertificateService;

	@Autowired
	public CandidateCertificatesController(CandidateCertificateService candidateCertificateService) {
		super();
		this.candidateCertificateService = candidateCertificateService;
	}
	
	@GetMapping("/getByCurriculumVitaeId")
	public DataResult<List<CandidateCertificate>> getByCurriculumVitaeId(int curriculumVitaeId){
		return this.candidateCertificateService.getByCurriculumVitaeId(curriculumVitaeId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCertificate candidateCertificate) {
		return this.candidateCertificateService.add(candidateCertificate);
	}
}
