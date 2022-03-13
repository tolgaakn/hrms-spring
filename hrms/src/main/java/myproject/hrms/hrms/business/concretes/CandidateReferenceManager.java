package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.CandidateReferenceService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.CandidateReferenceDao;
import myproject.hrms.hrms.entities.concretes.CandidateReference;

@Service
public class CandidateReferenceManager implements CandidateReferenceService {

	private CandidateReferenceDao candidateReferenceDao;

	@Autowired
	public CandidateReferenceManager(CandidateReferenceDao candidateReferenceDao) {
		super();
		this.candidateReferenceDao = candidateReferenceDao;
	}

	@Override
	public DataResult<List<CandidateReference>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CandidateReference>>(this.candidateReferenceDao.getByCurriculumVitaeId(curriculumVitaeId));
	}

	@Override
	public Result add(CandidateReference candidateReference) {
		this.candidateReferenceDao.save(candidateReference);
		return new SuccessResult("Referans eklendi.");
	}
}
