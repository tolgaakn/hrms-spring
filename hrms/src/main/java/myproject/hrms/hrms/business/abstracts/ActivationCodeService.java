package myproject.hrms.hrms.business.abstracts;

import myproject.hrms.hrms.core.entities.User;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	String createActivationCode(User user);
	
	Result activateUser(String activationCode);
	
	ActivationCode getByCode(String activationCode);
}
