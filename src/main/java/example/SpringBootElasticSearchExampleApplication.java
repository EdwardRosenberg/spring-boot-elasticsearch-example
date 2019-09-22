package example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.model.User;
import example.repository.UserRepository;

@SpringBootApplication
@RestController
public class SpringBootElasticSearchExampleApplication {
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/saveCustomer")
	public int saveCustomer(@RequestBody List<User> users) {
		repository.saveAll(users);
		return users.size();
	}

	@GetMapping("/findAll")
	public Iterable<User> findAllCustomers() {
		return repository.findAll();
	}

	@GetMapping("/findByFName/{firstName}")
	public List<User> findByFirstName(@PathVariable String firstName) {
		return repository.findByFirstName(firstName);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticSearchExampleApplication.class, args);
	}
}