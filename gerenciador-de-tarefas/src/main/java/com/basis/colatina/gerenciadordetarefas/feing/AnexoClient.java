package com.basis.colatina.gerenciadordetarefas.feing;

import com.basis.colatina.gerenciadordetarefas.service.dto.AnexoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "anexo", url = "${feign.client.anexo.url}")
public interface AnexoClient {

  String url = "api/anexo";

  @GetMapping(url)
  AnexoDTO getAnexo();

  @PostMapping(url)
  void uploadAnexo(@RequestBody AnexoDTO anexoDTO);

  @DeleteMapping(url)
  void deleteAnexo(String hash);


}
