package safetyfirst.safetyfirst;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	List<Doctor> findAllByStatus(String status);
}
