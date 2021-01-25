package safetyfirst.safetyfirst;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "covid1")
public class CovidOne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String disease;
	
	private String geneticDisorder;
	
	private String age;
	
	private String gender;

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getGeneticDisorder() {
		return geneticDisorder;
	}

	public void setGeneticDisorder(String geneticDisorder) {
		this.geneticDisorder = geneticDisorder;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}




	@Override
	public String toString() {
		return "CovidOne [id=" + id + ", disease=" + disease + ", geneticDisorder=" + geneticDisorder + ", age=" + age
				+ ", gender=" + gender + "]";
	}
}
