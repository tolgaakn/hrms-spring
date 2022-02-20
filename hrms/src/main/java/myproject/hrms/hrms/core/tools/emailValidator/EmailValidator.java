package myproject.hrms.hrms.core.tools.emailValidator;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator implements EmailValidatorService {

	@Override
	public Boolean validateEmail(String email, String companyName) {
		
		String[] result = email.split("@");
		String[] result2 = result[2].split(".");
		
		if (result2[1].toLowerCase() ==  companyName.toLowerCase()) {
			return true;
		}
		return false;
	}

	
}
