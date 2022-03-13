package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import myproject.hrms.hrms.business.abstracts.CandidateEducationService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.CandidateEducationDao;
import myproject.hrms.hrms.entities.concretes.CandidateEducation;

@Service
public class CandidateEducationManager implements CandidateEducationService {

	private CandidateEducationDao candidateEducationDao;

	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public DataResult<List<CandidateEducation>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getByCurriculumVitaeId(curriculumVitaeId));
	}

	@Override
	public Result add(@RequestBody CandidateEducation candidateEducation) {
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult("Eğitim bilgisi eklendi.");
	}
	
}
