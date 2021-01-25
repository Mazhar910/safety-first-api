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
public class CovidController {

	@Autowired
	CovidOneRepository covidOneRepository;

	@Autowired
	CovidTwoRepository covidTwoRepository;

	@Autowired
	CovidThreeRepository covidThreeRepository;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/covidOne")
	public ResponseEntity<CovidOne> createCovidOne(@RequestBody CovidOne covid1) {
		return ResponseEntity.ok(covidOneRepository.save(covid1));
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/covidTwo")
	public ResponseEntity<CovidTwo> createCovidTwo(@RequestBody CovidTwo covid2) {
		return ResponseEntity.ok(covidTwoRepository.save(covid2));
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/covidThree")
	public ResponseEntity<CovidThree> createCovidThree(@RequestBody CovidThree covid3) {
		System.out.println("inside covid 3");
		return ResponseEntity.ok(covidThreeRepository.save(covid3));
	}
	@RequestMapping(method = RequestMethod.GET, value = "/getCovidOne")
	public ResponseEntity<List<CovidOne>> fetchOne() {
		return ResponseEntity.ok(covidOneRepository.findAll());
	}
	@RequestMapping(method = RequestMethod.GET, value = "/getCovidTwo")
	public ResponseEntity<List<CovidTwo>> fetchTwo() {
		return ResponseEntity.ok(covidTwoRepository.findAll());
	}
	@RequestMapping(method = RequestMethod.GET, value = "/getCovidThree")
	public ResponseEntity<List<CovidThree>> fetchThree() {
		return ResponseEntity.ok(covidThreeRepository.findAll());
	}

}