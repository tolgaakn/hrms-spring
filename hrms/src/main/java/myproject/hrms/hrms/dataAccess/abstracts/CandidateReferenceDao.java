package myproject.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.hrms.entities.concretes.CandidateReference;

public interface CandidateReferenceDao extends JpaRepository<CandidateReference, Integer> {

	List<CandidateReference> getByCurriculumVitaeId(int curriculumVitaeId);
}
