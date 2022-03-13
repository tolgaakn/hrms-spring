package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.CandidateCertificateService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.CandidateCertificateDao;
import myproject.hrms.hrms.entities.concretes.CandidateCertificate;

@Service
public class CandidateCertificateManager implements CandidateCertificateService {

	private CandidateCertificateDao candidateCertificateDao;
	
	@Autowired
	public CandidateCertificateManager(CandidateCertificateDao candidateCertificateDao) {
		super();
		this.candidateCertificateDao = candidateCertificateDao;
	}

	@Override
	public DataResult<List<CandidateCertificate>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CandidateCertificate>>(this.candidateCertificateDao.getByCurriculumVitaeId(curriculumVitaeId));
	}

	@Override
	public Result add(CandidateCertificate candidateCertificate) {
		this.candidateCertificateDao.save(candidateCertificate);
		return new SuccessResult("Sertifika eklendi");
	}

}
