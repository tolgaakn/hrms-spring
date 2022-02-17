package myproject.hrms.hrms.business.concretes;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.ActivationCodeService;
import myproject.hrms.hrms.core.dataAccess.UserDao;
import myproject.hrms.hrms.core.entities.User;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.ActivationCodeDao;
import myproject.hrms.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService {
	
	private ActivationCodeDao activationCodeDao;
	private UserDao userDao;

	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao, UserDao userDao) {
		super();
		this.activationCodeDao = activationCodeDao;
		this.userDao = userDao;
	}

	@Override
	public String createActivationCode(User user) {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 128;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();


		ActivationCode activationCode = new ActivationCode();
		activationCode.setUserId(user.getId());
		activationCode.setActivationCode(generatedString);
		activationCode.setIsActivated(false);
		activationCodeDao.save(activationCode);
		
		return activationCode.toString();
	}

	@Override
	public Result activateUser(String activationCode) {
		User user = userDao.getById(activationCodeDao.findByActivationCode(activationCode).getUserId());
		user.setIsActive(true);
		ActivationCode activationCode2 = activationCodeDao.findByActivationCode(activationCode);
		activationCode2.setIsActivated(true);
		userDao.save(user);
		return new SuccessResult("Kullanıcı aktivasyonu gerçekleşti.");
	}

	@Override
	public ActivationCode getByCode(String activationCode) {
		return this.activationCodeDao.findByActivationCode(activationCode);
	}
}
