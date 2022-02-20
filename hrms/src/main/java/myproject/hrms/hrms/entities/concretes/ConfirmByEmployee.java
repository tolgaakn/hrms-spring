package myproject.hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employer_activation_employees")
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmByEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employer_id")
	private int employerId;
	
	@Column(name = "confirmed_employee_id")
	private int confirmedEmployeeId;
	
	@Column(name = "is_confirmed")
	private Boolean isConfirmed;
	
	@Column(name = "confirm_date")
	private Date confirmDate;
}
