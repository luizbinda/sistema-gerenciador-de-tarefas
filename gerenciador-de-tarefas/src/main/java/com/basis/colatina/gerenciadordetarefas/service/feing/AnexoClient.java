package com.basis.colatina.gerenciadordetarefas.service.feing;

import com.basis.colatina.gerenciadordetarefas.service.dto.AnexoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "anexo", url = "${feign.client.anexo.url}")
public interface AnexoClient {

  @GetMapping("api/anexo/{hash}")
  AnexoDTO getAnexo(@PathVariable String hash);

  @PostMapping("api/anexo")
  void uploadAnexo(@RequestBody AnexoDTO anexoDTO);

  @DeleteMapping("api/anexo/{hash}")
  void deleteAnexo(@PathVariable String hash);


}
