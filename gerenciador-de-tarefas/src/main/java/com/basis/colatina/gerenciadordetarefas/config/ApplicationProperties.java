package com.basis.colatina.gerenciadordetarefas.config;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application")
@Configuration
@Getter
@Setter
public class ApplicationProperties {
  ElasticSearch elasticsearch;

  @Getter
  @Setter
  public static final class ElasticSearch {
    String url;
  }
}
