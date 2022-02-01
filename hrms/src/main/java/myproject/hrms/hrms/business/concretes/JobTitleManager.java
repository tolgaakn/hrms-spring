package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.JobTitleService;
import myproject.hrms.hrms.dataAccess.abstracts.JobTitleDao;
import myproject.hrms.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}
	
}
