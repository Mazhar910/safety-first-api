package safetyfirst.safetyfirst;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "covid3")
public class CovidThree {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String face;

	private String dehydration;

	private String bloodPressure;

	public String getFace() {
		return face;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setFace(String face) {
		this.face = face;
	}

	public String getDehydration() {
		return dehydration;
	}

	public void setDehydration(String dehydration) {
		this.dehydration = dehydration;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	@Override
	public String toString() {
		return "Covid3 [id=" + id + ", face=" + face + ", dehydration=" + dehydration + ", bloodPressure="
				+ bloodPressure + "]";
	}

}
