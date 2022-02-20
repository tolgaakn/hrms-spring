package myproject.hrms.hrms.core.tools.emailValidator;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator implements EmailValidatorService {

	@Override
	public Boolean validateEmail(String email, String companyName) {
		
		String[] result = email.split("@");
		String[] result2 = result[1].split(".");
		
		if (result2[0].toLowerCase().equals(companyName.toLowerCase())) {
			return true;
		}
		return false;
	}

	
}
