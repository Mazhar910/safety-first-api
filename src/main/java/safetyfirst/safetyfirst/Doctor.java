package safetyfirst.safetyfirst;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String status;
	
	private String email;
	
	private String qualifications;
	
	private String phone;
	
	private String hospitals;
	
	private String clinic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHospitals() {
		return hospitals;
	}

	public void setHospitals(String hospitals) {
		this.hospitals = hospitals;
	}

	public String getClinic() {
		return clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", status=" + status + ", email=" + email + ", qualifications="
				+ qualifications + ", phone=" + phone + ", hospitals=" + hospitals + ", clinic=" + clinic + "]";
	}


}
