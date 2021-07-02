package com.basis.colatina.gerenciadordeanexos.service;

import com.basis.colatina.gerenciadordeanexos.config.ApplicationProperties;
import com.basis.colatina.gerenciadordeanexos.service.dto.AnexoDTO;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;


@Service
@RequiredArgsConstructor
public class AnexoService {

  private final MinioClient minioClient;
  private final ApplicationProperties applicationProperties;

  @SneakyThrows
  public AnexoDTO index(String hash) {
    return new AnexoDTO(
            hash,
            IOUtils.toString(
                    minioClient.getObject(
                            GetObjectArgs.builder()
                                    .bucket(applicationProperties.getMinio().getBucket())
                                    .object(hash)
                                    .build()
                    ),
                    StandardCharsets.UTF_8
            )
    );
  }

  @SneakyThrows
  public void upload(AnexoDTO anexoDTO) {
    minioClient.putObject(
            PutObjectArgs.builder()
                    .bucket(applicationProperties.getMinio().getBucket())
                    .object(anexoDTO.getHash())
                    .stream(new ByteArrayInputStream(anexoDTO.getAnexo().getBytes()), anexoDTO.getAnexo().length(), 0)
                    .build()
    );
  }

  @SneakyThrows
  public void delete(String hash) {
    minioClient.removeObject(
            RemoveObjectArgs.builder()
                    .bucket(applicationProperties.getMinio().getBucket())
                    .object(hash)
                    .build());
  }


}
