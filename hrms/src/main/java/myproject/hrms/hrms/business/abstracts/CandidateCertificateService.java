package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateCertificate;

public interface CandidateCertificateService {

	DataResult<List<CandidateCertificate>> getByCurriculumVitaeId(int curriculumVitaeId);
	Result add(CandidateCertificate candidateCertificate);
}
