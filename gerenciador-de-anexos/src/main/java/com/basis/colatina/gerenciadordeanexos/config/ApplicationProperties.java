package com.basis.colatina.gerenciadordeanexos.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application")
@Configuration
@Getter
@Setter
public class ApplicationProperties {
  MinioConfig minio;

  @Getter
  @Setter
  public static final class MinioConfig {
    String user;
    String password;
    String url;
    String bucket;
  }
}
