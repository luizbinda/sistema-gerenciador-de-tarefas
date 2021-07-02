package com.basis.colatina.gerenciadordetarefas.config;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@RequiredArgsConstructor
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.basis.colatina.gerenciadordetarefas.repository.elasticsearch")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

  private final ApplicationProperties applicationProperties;

  @Bean
  @Override
  public RestHighLevelClient elasticsearchClient() {

    final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            .connectedTo(applicationProperties.getElasticsearch().getUrl())
            .build();

    return RestClients.create(clientConfiguration).rest();
  }



}
