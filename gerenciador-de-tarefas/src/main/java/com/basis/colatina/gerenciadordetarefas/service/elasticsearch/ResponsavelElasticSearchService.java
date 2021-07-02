package com.basis.colatina.gerenciadordetarefas.service.elasticsearch;

import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.ResponsavelDocument;
import com.basis.colatina.gerenciadordetarefas.repository.ResponsavelRepository;
import com.basis.colatina.gerenciadordetarefas.repository.elasticsearch.ResponsavelSearchRepository;
import com.basis.colatina.gerenciadordetarefas.service.event.ResponsavelEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ResponsavelElasticSearchService {
  private final ResponsavelRepository responsavelRepository;
  private final ResponsavelSearchRepository responsavelSearchRepository;

  @TransactionalEventListener(fallbackExecution = true)
  public void indexar(ResponsavelEvent event) {
    log.info("Indexando responsavel: {}", event.getId());
    ResponsavelDocument document = responsavelRepository.getById(event.getId());
    responsavelSearchRepository.save(document);
  }



}
