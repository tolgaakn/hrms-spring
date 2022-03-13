package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {

	DataResult<List<CandidateLanguage>> getByCurriculumVitaeId(int curriculumVitaeId);
	Result add(CandidateLanguage candidateLanguage);
}
