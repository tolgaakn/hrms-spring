package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.entities.concretes.JobType;

public interface JobTypeService {

	DataResult<List<JobType>> getAll();
}
