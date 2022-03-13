package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceService {

	DataResult<List<CandidateExperience>> getByCurriculumVitaeID(int curriculumVitaeId);
	Result add(CandidateExperience candidateExperience);
}
