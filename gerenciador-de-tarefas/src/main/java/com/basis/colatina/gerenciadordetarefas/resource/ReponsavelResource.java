package com.basis.colatina.gerenciadordetarefas.resource;

import com.basis.colatina.gerenciadordetarefas.service.ResponsavelService;
import com.basis.colatina.gerenciadordetarefas.service.dto.ResponsavelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reponsavel")
public class ReponsavelResource {

  private final ResponsavelService responsavelService;

  @GetMapping
  public ResponseEntity<List<ResponsavelDTO>> index() {
    return  new ResponseEntity<List<ResponsavelDTO>>(responsavelService.index(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponsavelDTO> show() {
    return  new ResponseEntity<ResponsavelDTO>(responsavelService.show(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponsavelDTO> save(ResponsavelDTO responsavelDTO) {
    return  new ResponseEntity<ResponsavelDTO>(responsavelService.save(responsavelDTO), HttpStatus.OK);
  }

}
