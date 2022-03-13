package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationService {

	DataResult<List<CandidateEducation>> getByCurriculumVitaeId(int curriculumVitaeId);
	Result add(CandidateEducation candidateEducation);
}
