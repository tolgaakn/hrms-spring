package myproject.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.hrms.entities.concretes.CandidateProject;

public interface CandidateProjectDao extends JpaRepository<CandidateProject, Integer> {

	List<CandidateProject> getByCurriculumVitaeId(int curriculumVitaeId);
}
