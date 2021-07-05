package com.basis.colatina.gerenciadordetarefas.repository.elasticsearch;

import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.AnexoDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AnexoSearchRepository extends ElasticsearchRepository<AnexoDocument, Integer> {

}
