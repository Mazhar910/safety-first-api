package safetyfirst.safetyfirst;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthController {
	@Autowired
	UserService userService;


	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@RequestMapping(method = RequestMethod.GET, value = { "", "/" })
	public ResponseEntity<Map<Object, Object>> defaultRoute() {
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "Server app is running fine :)");
		return ok(model);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Map<Object, Object>> register(@RequestBody User user) {

		User savedUser = null;
		User userExists = userService.findByPhoneOrEmail(user.getPhone());
		Map<Object, Object> model = new HashMap<>();
		String message = "Acoount created and activation email sent successfully.";
		if (userExists != null) {
			message = "User with phone: " + user.getPhone() + " already exists";
		} else {
			savedUser = userService.saveUser(user);
		}
		model.put("user", savedUser);
		model.put("message", message);
		return ok(model);
	}
	@PostMapping("/login")
	public ResponseEntity<Map<Object, Object>> login(@RequestBody LoginDto loginDto) {
		logger.info("login : start");
		Map<Object, Object> model = new HashMap<>();
		User user = null;
		String jwt = null;
		try {
			String phone = loginDto.getPhone();
			String password = loginDto.getPassword();

			if (phone == null || password == null) {
				model.put("jwt", jwt);
				model.put("status", "FAIL");
				model.put("user", user);
				model.put("message", "Invalid or Bad credentials");
				return ok(model);
			}

			user = userService.findByPhoneOrEmailAndPassword(phone, password);

			if (user == null) {
				model.put("jwt", jwt);
				model.put("status", "FAIL");
				model.put("user", user);
				model.put("message", "User with this phone is not available.");
				return ok(model);
			}
			if (user != null && user.getStatus().equals("inactive")) {
				model.put("jwt", jwt);
				model.put("status", "FAIL");
				model.put("user", user);
				model.put("message", "Your Account is not active. Kindly contact support.");
				return ok(model);
			}
			//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phone, loginDto.getPassword()));
			jwt = phone;
			model.put("jwt", jwt);
			model.put("status", "SUCCESS");
			model.put("user", user);
			model.put("message", "Access token generated successfully.");
			return ok(model);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			model.put("jwt", jwt);
			model.put("status", "FAIL");
			model.put("user", user);
			model.put("message", "Invalid or Bad credentials");
			return ok(model);
		}
	}



}