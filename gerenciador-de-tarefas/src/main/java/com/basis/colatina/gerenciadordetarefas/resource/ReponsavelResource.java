package com.basis.colatina.gerenciadordetarefas.resource;

import com.basis.colatina.gerenciadordetarefas.service.ResponsavelService;
import com.basis.colatina.gerenciadordetarefas.service.dto.ResponsavelDTO;
import com.basis.colatina.gerenciadordetarefas.service.elasticsearch.ResponsavelElasticSearchService;
import com.basis.colatina.gerenciadordetarefas.service.filter.ResponsavelFilter;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/responsavel")
public class ReponsavelResource {

  private final ResponsavelService responsavelService;

  @PostMapping("index")
  public ResponseEntity<Page<ResponsavelDTO>> index(@RequestBody ResponsavelFilter filter, Pageable pageable) {
    return  new ResponseEntity<>(responsavelService.index(filter, pageable), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponsavelDTO> show(@PathVariable Integer id) {
    return  new ResponseEntity<>(responsavelService.show(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponsavelDTO> save(@RequestBody @Valid ResponsavelDTO responsavelDTO) {
    return  new ResponseEntity<>(responsavelService.save(responsavelDTO), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<ResponsavelDTO> update(@RequestBody @Valid ResponsavelDTO responsavelDTO) {
    return  new ResponseEntity<>(responsavelService.save(responsavelDTO), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponsavelDTO> delte(@PathVariable Integer id) {
    responsavelService.delete(id);
    return  new ResponseEntity<>(null, HttpStatus.OK);
  }

}
