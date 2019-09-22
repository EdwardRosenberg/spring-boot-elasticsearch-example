package example;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import pl.allegro.tech.embeddedelasticsearch.EmbeddedElastic;
import pl.allegro.tech.embeddedelasticsearch.PopularProperties;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"repository"})
@EnableAutoConfiguration(exclude = ElasticsearchAutoConfiguration.class)
public class Config extends AbstractElasticsearchConfiguration {

	static EmbeddedElastic embeddedElastic = embeddedElastic();

	public static EmbeddedElastic embeddedElastic() {
		if (embeddedElastic != null) return embeddedElastic;
		try {
			embeddedElastic = EmbeddedElastic.builder()
									  .withElasticVersion("6.8.1")
									  .withSetting(PopularProperties.HTTP_PORT, 9200)
									  .withSetting(PopularProperties.CLUSTER_NAME, "es")
									  .withDownloadDirectory(new File("target/download"))
									  .withInstallationDirectory(new File("target/elasticsearch"))
									  .withStartTimeout(180, TimeUnit.SECONDS)
									  .build()
									  .start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return embeddedElastic;
	}

	@Bean
	@Primary
	@Override
	public RestHighLevelClient elasticsearchClient() {
		return RestClients.create(ClientConfiguration.localhost()).rest();
	}
}
