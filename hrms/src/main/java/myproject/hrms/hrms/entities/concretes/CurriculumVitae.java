package myproject.hrms.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "curriculum_vitaes")
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "candidate_id")
	private int candidateId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateEducation> candidateEducations;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateExperience> candidateExperiences;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateLanguage> candidateLanguages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateCertificate> candidateCertificates;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateReference> candidateReferences;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateProject> candidateProjects;
}













