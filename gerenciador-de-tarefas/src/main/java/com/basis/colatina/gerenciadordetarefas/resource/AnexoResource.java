package com.basis.colatina.gerenciadordetarefas.resource;

import com.basis.colatina.gerenciadordetarefas.service.AnexoService;
import com.basis.colatina.gerenciadordetarefas.service.dto.AnexoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/anexo")
public class AnexoResource {

  private final AnexoService anexoService;

  @GetMapping
  public ResponseEntity<List<AnexoDTO>> index() {
    return  new ResponseEntity<List<AnexoDTO>>(anexoService.index(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AnexoDTO> show(@PathVariable Integer id) {
    return  new ResponseEntity<AnexoDTO>(anexoService.show(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<AnexoDTO> save(@RequestBody @Valid AnexoDTO anexoDTO) {
    return  new ResponseEntity<AnexoDTO>(anexoService.save(anexoDTO), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<AnexoDTO> update(@RequestBody @Valid AnexoDTO anexoDTO) {
    return  new ResponseEntity<AnexoDTO>(anexoService.save(anexoDTO), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<AnexoDTO> delte(@PathVariable Integer id) {
    anexoService.delete(id);
    return  new ResponseEntity<>(null, HttpStatus.OK);
  }

}
