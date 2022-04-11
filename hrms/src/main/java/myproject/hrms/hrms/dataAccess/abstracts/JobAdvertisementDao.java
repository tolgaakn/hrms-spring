package myproject.hrms.hrms.dataAccess.abstracts;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import myproject.hrms.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByActive(Boolean isActive);
	
	@Query("From JobAdvertisement where createdDate=:createdDate")
	List<JobAdvertisement> getByCreatedDate(ZonedDateTime createdDate);
	List<JobAdvertisement> getByLastDate(ZonedDateTime lastDate);
	List<JobAdvertisement> getByActiveAndEmployer_Id(Boolean isActive, int employerId);
	
	@Query("Select new myproject.hrms.hrms.entities.dtos.JobAdvertisementDto(j.id, e.id, e.companyName, jp.title, j.openPosition, j.jobDescription, j.createdDate, j.lastDate,"
			+ "j.minSalary, j.maxSalary, c.name, jt.jobTypeName, wt.workTypeName) "
			+ "From JobAdvertisement j Inner Join j.employer e "
			+ "Inner Join j.jobPosition jp "
			+ "Inner Join j.city c "
			+ "Inner Join j.jobType jt "
			+ "Inner Join j.workType wt Where j.id=:advertisementId")
	JobAdvertisementDto getById(int advertisementId);
}
