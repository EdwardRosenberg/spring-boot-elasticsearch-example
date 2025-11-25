package example;

import example.model.User;
import example.model.UserType;
import example.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class UserRepositoryIntegrationTest {

	@Autowired
	private UserRepository userRepository;

	@BeforeEach
	void setUp() {
		userRepository.deleteAll();
	}

	@Test
	void shouldSaveAndFindUser() {
		User user = new User("John", "Doe", UserType.USER);
		User savedUser = userRepository.save(user);

		assertThat(savedUser.getId()).isNotNull();
		assertThat(userRepository.findById(savedUser.getId())).isPresent();
	}

	@Test
	void shouldFindByFirstName() {
		userRepository.save(new User("Alice", "Smith", UserType.ADMIN));
		userRepository.save(new User("Bob", "Jones", UserType.USER));
		userRepository.save(new User("Alice", "Brown", UserType.GUEST));

		List<User> aliceUsers = userRepository.findByFirstName("Alice");

		assertThat(aliceUsers).hasSize(2);
		assertThat(aliceUsers).allMatch(u -> u.getFirstName().equals("Alice"));
	}

	@Test
	void shouldFindAllByUserType() {
		userRepository.save(new User("Admin1", "User", UserType.ADMIN));
		userRepository.save(new User("Admin2", "User", UserType.ADMIN));
		userRepository.save(new User("Regular", "User", UserType.USER));

		List<User> adminUsers = userRepository.findAllByUserType(UserType.ADMIN);

		assertThat(adminUsers).hasSize(2);
		assertThat(adminUsers).allMatch(u -> u.getUserType() == UserType.ADMIN);
	}

}
