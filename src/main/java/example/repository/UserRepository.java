package example.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import example.model.User;

public interface UserRepository extends ElasticsearchRepository<User, String>{

	List<User> findByFirstName(String firstName);

}
