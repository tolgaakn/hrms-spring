package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.ConfirmByEmployee;
import myproject.hrms.hrms.entities.concretes.Employer;

public interface ConfirmByEmployeeService {
	
	DataResult<List<ConfirmByEmployee>> getAll();
	
	Result createActivationRequest(Employer employer);
	
	Result activateEmployer(int employerId);
}
