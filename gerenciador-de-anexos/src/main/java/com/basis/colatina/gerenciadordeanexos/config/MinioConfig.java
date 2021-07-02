package com.basis.colatina.gerenciadordeanexos.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
@Configuration
public class MinioConfig {

  private final ApplicationProperties applicationProperties;

  @Bean
  @SneakyThrows
  public MinioClient minioClient() {
    MinioClient minioClient =
            MinioClient.builder()
                    .endpoint(applicationProperties.getMinio().getUrl())
                    .credentials(applicationProperties.getMinio().getUser(), applicationProperties.getMinio().getPassword())
                    .build();

    if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(applicationProperties.getMinio().getBucket()).build())) {
      minioClient.makeBucket(MakeBucketArgs.builder().bucket(applicationProperties.getMinio().getBucket()).build());
    }

    return minioClient;
  }



}
