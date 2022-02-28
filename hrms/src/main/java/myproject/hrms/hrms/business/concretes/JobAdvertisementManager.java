package myproject.hrms.hrms.business.concretes;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.JobAdvertisementService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.Result;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import myproject.hrms.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActive(true));
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByCreatedDate(ZonedDateTime createdDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCreatedDate(createdDate));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByLastDate(ZonedDateTime lastDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCreatedDate(lastDate));
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı oluşturuldu.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveAndEmployer_Id(true, employerId));
	}

}
