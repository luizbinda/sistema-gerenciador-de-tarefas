package com.basis.colatina.gerenciadordetarefas.resource;

import com.basis.colatina.gerenciadordetarefas.service.TarefaService;
import com.basis.colatina.gerenciadordetarefas.service.dto.TarefaDTO;
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
@RequestMapping("/api/tarefa")
public class TarefaResource {

  private final TarefaService tarefaService;

  @GetMapping
  public ResponseEntity<List<TarefaDTO>> index() {
    return  new ResponseEntity<>(tarefaService.index(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TarefaDTO> show(@PathVariable Integer id) {
    return  new ResponseEntity<>(tarefaService.show(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<TarefaDTO> save(@RequestBody @Valid TarefaDTO tarefaDTO) {
    return  new ResponseEntity<>(tarefaService.save(tarefaDTO), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<TarefaDTO> update(@RequestBody @Valid TarefaDTO tarefaDTO) {
    return  new ResponseEntity<>(tarefaService.save(tarefaDTO), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<TarefaDTO> delte(@PathVariable Integer id) {
    tarefaService.delete(id);
    return  new ResponseEntity<>(null, HttpStatus.OK);
  }

}
