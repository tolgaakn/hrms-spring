package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.CandidateCoverLetterService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.CandidateCoverLetterDao;
import myproject.hrms.hrms.entities.concretes.CandidateCoverLetter;

@Service
public class CandidateCoverLetterManager implements CandidateCoverLetterService {

	private CandidateCoverLetterDao candidateCoverLetterDao;
	
	@Autowired
	public CandidateCoverLetterManager(CandidateCoverLetterDao candidateCoverLetterDao) {
		super();
		this.candidateCoverLetterDao = candidateCoverLetterDao;
	}

	@Override
	public DataResult<List<CandidateCoverLetter>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateCoverLetter>>(this.candidateCoverLetterDao.getByCandidateId(candidateId));
	}

	@Override
	public Result add(CandidateCoverLetter candidateCoverLetter) {
		this.candidateCoverLetterDao.save(candidateCoverLetter);
		return new SuccessResult("Önyazı eklendi.");
	}

}
