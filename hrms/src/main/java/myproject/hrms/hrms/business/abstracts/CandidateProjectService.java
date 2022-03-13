package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateProject;

public interface CandidateProjectService {

	DataResult<List<CandidateProject>> getByCurriculumVitaeId(int curriculumVitaeId);
	Result add(CandidateProject candidateProject);
}
