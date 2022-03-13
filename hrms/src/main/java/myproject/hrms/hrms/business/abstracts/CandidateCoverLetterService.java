package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CandidateCoverLetter;

public interface CandidateCoverLetterService {

	DataResult<List<CandidateCoverLetter>> getByCandidateId(int candidateId);
	Result add(CandidateCoverLetter candidateCoverLetter);
}
