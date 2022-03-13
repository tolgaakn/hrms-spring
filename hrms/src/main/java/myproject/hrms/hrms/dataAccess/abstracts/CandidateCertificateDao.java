package myproject.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.hrms.entities.concretes.CandidateCertificate;

public interface CandidateCertificateDao extends JpaRepository<CandidateCertificate, Integer> {

	List<CandidateCertificate> getByCurriculumVitaeId(int curriculumVitaeId);
}
