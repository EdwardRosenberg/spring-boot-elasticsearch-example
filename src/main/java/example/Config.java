package example;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"example.repository"})
public class Config {
	// Spring Data Elasticsearch auto-configuration handles client setup
	// Configure connection via application.properties
}
