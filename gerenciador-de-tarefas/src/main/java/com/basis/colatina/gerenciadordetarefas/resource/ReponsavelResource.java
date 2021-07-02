package com.basis.colatina.gerenciadordetarefas.resource;

import com.basis.colatina.gerenciadordetarefas.service.ResponsavelService;
import com.basis.colatina.gerenciadordetarefas.service.dto.ResponsavelDTO;
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
import java.util.List;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/responsavel")
public class ReponsavelResource {

  private final ResponsavelService responsavelService;

  @GetMapping
  public ResponseEntity<List<ResponsavelDTO>> index() {
    return  new ResponseEntity<List<ResponsavelDTO>>(responsavelService.index(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponsavelDTO> show(@PathVariable Integer id) {
    return  new ResponseEntity<ResponsavelDTO>(responsavelService.show(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponsavelDTO> save(@RequestBody @Valid ResponsavelDTO responsavelDTO) {
    return  new ResponseEntity<ResponsavelDTO>(responsavelService.save(responsavelDTO), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<ResponsavelDTO> update(@RequestBody @Valid ResponsavelDTO responsavelDTO) {
    return  new ResponseEntity<ResponsavelDTO>(responsavelService.save(responsavelDTO), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponsavelDTO> delte(@PathVariable Integer id) {
    responsavelService.delete(id);
    return  new ResponseEntity<>(null, HttpStatus.OK);
  }

}
