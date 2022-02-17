package myproject.hrms.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.hrms.business.abstracts.ActivationCodeService;
import myproject.hrms.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activation-codes")
public class ActivationCodesController {
	
	private ActivationCodeService activationCodeService;

	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	
	@GetMapping("/activate/{activationCode}")
	public Result activateUser(String activationCode) {
		return activationCodeService.activateUser(activationCode);
	}
	
}
