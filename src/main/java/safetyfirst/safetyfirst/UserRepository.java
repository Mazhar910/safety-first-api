package safetyfirst.safetyfirst;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	User findByPhoneAndStatus(String phone, String status);

	User findByEmailAndStatus(String email, String status);

	User findByPhone(String phone);

	User findByEmail(String email);

	User findByUsername(String username);
}
