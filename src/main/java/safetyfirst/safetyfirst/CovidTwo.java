package safetyfirst.safetyfirst;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "covid2")
public class CovidTwo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String getPrecautions() {
		return precautions;
	}

	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	private String breathing;

	private String precautions;

	public String getBreathing() {
		return breathing;
	}

	public void setBreathing(String breathing) {
		this.breathing = breathing;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




	@Override
	public String toString() {
		return "Covid2 [id=" + id + ", breathing=" + breathing + ", precautions=" + precautions + "]";
	}

}
