package myproject.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.hrms.business.abstracts.CityService;
import myproject.hrms.hrms.core.utilities.results.DataResult;
import myproject.hrms.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.hrms.dataAccess.abstracts.CityDao;
import myproject.hrms.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

}
