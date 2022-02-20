package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.ConfirmByEmployeeService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.ConfirmByEmployeeDao;
import myproject.hrms.hrms.entities.concretes.ConfirmByEmployee;
import myproject.hrms.hrms.entities.concretes.Employer;

@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {

	private ConfirmByEmployeeDao confirmByEmployeeDao;

	@Autowired
	public ConfirmByEmployeeManager(ConfirmByEmployeeDao confirmByEmployeeDao) {
		super();
		this.confirmByEmployeeDao = confirmByEmployeeDao;
	}

	@Override
	public DataResult<List<ConfirmByEmployee>> getAll() {
		return new SuccessDataResult<List<ConfirmByEmployee>>(this.confirmByEmployeeDao.findAll());
	}

	@Override
	public Result createActivationRequest(Employer employer) {
		ConfirmByEmployee confirmByEmployee = new ConfirmByEmployee();
		confirmByEmployee.setEmployerId(employer.getId());
		confirmByEmployee.setIsConfirmed(false);
		confirmByEmployeeDao.save(confirmByEmployee);
		return new SuccessResult("Kaydınız sistem personeli tarafından onaylanacaktır.");
	}

	@Override
	public Result activateEmployer(int employerId) {
		ConfirmByEmployee confirmByEmployee = confirmByEmployeeDao.findByEmployerId(employerId);
		confirmByEmployee.setIsConfirmed(true);
		confirmByEmployeeDao.save(confirmByEmployee);
		return new SuccessResult("İşveren onaylandı.");
	}
}
