package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.CandidateProjectService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.CandidateProjectDao;
import myproject.hrms.hrms.entities.concretes.CandidateProject;

@Service
public class CandidateProjectManager implements CandidateProjectService {

	private CandidateProjectDao candidateProjectDao;

	@Autowired
	public CandidateProjectManager(CandidateProjectDao candidateProjectDao) {
		super();
		this.candidateProjectDao = candidateProjectDao;
	}

	@Override
	public DataResult<List<CandidateProject>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CandidateProject>>(this.candidateProjectDao.getByCurriculumVitaeId(curriculumVitaeId));
	}

	@Override
	public Result add(CandidateProject candidateProject) {
		this.candidateProjectDao.save(candidateProject);
		return new SuccessResult("Proje eklendi.");
	}
}
