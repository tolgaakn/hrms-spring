package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateReference;

public interface CandidateReferenceService {

	DataResult<List<CandidateReference>> getByCurriculumVitaeId(int curriculumVitaeId);
	Result add(CandidateReference candidateReference);
}
