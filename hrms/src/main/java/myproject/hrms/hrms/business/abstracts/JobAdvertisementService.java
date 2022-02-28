package myproject.hrms.hrms.business.abstracts;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByActive();
	
	@Query("From JobAdvertisement where createdDate=:createdDate")
	DataResult<List<JobAdvertisement>> getByCreatedDate(ZonedDateTime createdDate);
	DataResult<List<JobAdvertisement>> getByLastDate(ZonedDateTime lastDate);
	
	DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(int employerId);
	Result add(JobAdvertisement jobAdvertisement);
}
