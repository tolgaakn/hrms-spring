package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.EmployerService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.EmployerDao;
import myproject.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Şirketler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		//TODO: Web sitesi ile aynı domaine sahip mail adresi kontrolü.
		//TODO: Şifre tekrarı kontrolü.
		//TODO: E-posta doğrulaması ve sistem personeli onayı.
		//TODO: E-posta kayıtlı ise kayıt gerçekleşmez.
		this.employerDao.save(employer);
		return new SuccessResult("Şirket kaydedildi.");
	}
}
