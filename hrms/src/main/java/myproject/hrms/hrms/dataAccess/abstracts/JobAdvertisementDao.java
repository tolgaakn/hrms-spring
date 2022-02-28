package myproject.hrms.hrms.dataAccess.abstracts;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByActive(Boolean isActive);
	List<JobAdvertisement> getByCreatedDate(ZonedDateTime createdDate);
	List<JobAdvertisement> getByLastDate(ZonedDateTime lastDate);
	List<JobAdvertisement> getByActiveAndEmployer_Id(Boolean isActive, int employerId);
}
