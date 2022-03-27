package myproject.hrms.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.entities.concretes.WorkType;

public interface WorkTypeService {

	DataResult<List<WorkType>> getAll();
}
