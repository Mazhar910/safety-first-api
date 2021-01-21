package safetyfirst.safetyfirst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		user.setPassword(user.getPassword());
		user.setStatus("active");
		// Role userRole = roleRepository.findByName(AppConstants.ADMIN_ROLE_NAME);
		// user.setRole(userRole);
		return userRepository.save(user);
	}

	public User findByPhone(String phone) {
		return userRepository.findByPhoneAndStatus(phone,"active");
	}

	public User findByPhoneOrEmail(String phoneOrEmail) {
		User user = userRepository.findByPhoneAndStatus(phoneOrEmail,"active");
		if (user == null) {
			user = userRepository.findByEmailAndStatus(phoneOrEmail,
					"inactive");
		}
		return user;
	}

	public User findByPhoneOrEmailAndPassword(String phoneOrEmail, String password) {
		User user = userRepository.findByPhoneAndStatus(phoneOrEmail,"active");
		if (user == null) {
			user = userRepository.findByEmailAndStatus(phoneOrEmail,"active");
		}
		if (user != null && password ==  user.getPassword()) {
			return user;
		}
		return user;
	}

}