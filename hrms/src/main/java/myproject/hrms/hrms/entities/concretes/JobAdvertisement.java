package myproject.hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "employer_id")
	//private int employerId;
	
	//@Column(name = "job_position_id")
	//private int jobPositionId;
	
	//@Column(name = "city_id")
	//private int cityId;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "open_position")
	private int openPosition;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "last_date")
	private Date lastDate;
	
	@Column(name = "closed")
	private Boolean closed;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "deleted")
	private Boolean deleted;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "is_confirmed")
	private Boolean isConfirmed;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "job_type_id")
	private JobType jobType;
	
	@ManyToOne()
	@JoinColumn(name = "work_type_id")
	private WorkType workType;
}
