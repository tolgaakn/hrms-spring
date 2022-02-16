package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.CandidateService;
import myproject.hrms.hrms.core.tools.hash.PasswordAuthenticationService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.CandidateDao;
import myproject.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private PasswordAuthenticationService passwordAuthenticationService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, PasswordAuthenticationService passwordAuthenticationService) {
		super();
		this.candidateDao = candidateDao;
		this.passwordAuthenticationService = passwordAuthenticationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		//TODO: Password hash eklenecek.
		//TODO: {field} alanı boş bırakılamaz uyarısı eklenecek.
		//TODO: Mernis doğrulaması eklenecek.
		//TODO: E-posta ve TC no kayıtlı ise kayıt gerçekleşmeyecek.
		//TODO: Kaydın gerçekleşmesi için e-posta doğrulaması gerekli.
		
		char[] charPassword = candidate.getPassword().toCharArray();
		this.passwordAuthenticationService.hash(charPassword);
		candidate.setPassword(this.passwordAuthenticationService.hash(charPassword));
		this.candidateDao.save(candidate);
		return new SuccessResult("Kullanıcı eklendi.");
	}

}






