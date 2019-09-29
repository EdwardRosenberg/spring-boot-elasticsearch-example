package example.controller;

import example.model.User;
import example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return repository.save(user);
	}

	@PostMapping("/saveAll")
	public int saveCustomer(@RequestBody List<User> users) {
		repository.saveAll(users);
		return users.size();
	}

	@GetMapping
	public Iterable<User> findAllUsers() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public User findUserById(@PathVariable String id) {
		return repository.findById(id).orElse(null);
	}

	@GetMapping("/findByFirstName/{firstName}")
	public List<User> findByFirstName(@PathVariable String firstName) {
		return repository.findByFirstName(firstName);
	}
}
