package myproject.hrms.hrms.business.abstracts;


import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	CurriculumVitae getById(int id);
	Result add(CurriculumVitae curriculumVitae);
}
