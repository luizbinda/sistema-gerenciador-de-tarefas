package com.basis.colatina.gerenciadordeanexos.resource;

import com.basis.colatina.gerenciadordeanexos.service.AnexoService;
import com.basis.colatina.gerenciadordeanexos.service.dto.AnexoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/anexos")
public class AnexoResource {
  private final AnexoService anexoService;

  @GetMapping("/{hash}")
  public ResponseEntity<AnexoDTO> index(@PathVariable String hash) {
    return new ResponseEntity<>(anexoService.index(hash), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<AnexoDTO> upload(@RequestBody AnexoDTO anexoDTO) {
    anexoService.upload(anexoDTO);
    return new ResponseEntity<>(null, HttpStatus.OK);
  }

  @DeleteMapping("/{hash}")
  public ResponseEntity<String> delete(@PathVariable String hash) {
    anexoService.delete(hash);
    return new ResponseEntity<>(null, HttpStatus.OK);
  }
}
