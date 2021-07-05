package com.basis.colatina.gerenciadordetarefas.service.elasticsearch;

import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.AnexoDocument;
import com.basis.colatina.gerenciadordetarefas.repository.AnexoRepository;
import com.basis.colatina.gerenciadordetarefas.repository.elasticsearch.AnexoSearchRepository;
import com.basis.colatina.gerenciadordetarefas.service.event.AnexoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AnexoElasticSearchService {
  private final AnexoRepository anexoRepository;
  private final AnexoSearchRepository anexoSearchRepository;

  @TransactionalEventListener(fallbackExecution = true)
  public void indexar(AnexoEvent event) {
    log.info("Indexando anexo: {}", event.getId());
    AnexoDocument document = anexoRepository.getById(event.getId());
    anexoSearchRepository.save(document);
  }



}
