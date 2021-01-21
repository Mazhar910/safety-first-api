package safetyfirst.safetyfirst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DoctorController {

	@Autowired
	DoctorRepository doctorRepository;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/doctor")
	public ResponseEntity<Doctor> createCategory(@RequestBody Doctor doctor) {
		return ResponseEntity.ok(doctorRepository.save(doctor));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/doctors")
	public ResponseEntity<List<Doctor>> fetch() {
		return ResponseEntity.ok(doctorRepository.findAll());
	}

}
