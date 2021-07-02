package com.basis.colatina.gerenciadordetarefas.feing;

import com.basis.colatina.gerenciadordetarefas.service.dto.AnexoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "anexo", url = "${feign.client.anexo.url}")
public interface AnexoClient {

  String url = "api/anexos";

  @GetMapping(url)
  AnexoDTO getAnexo();

  @PostMapping(url)
  void uploadAnexo(AnexoDTO anexoDTO);

  @DeleteMapping(url)
  void deleteAnexo(String hash);


}
