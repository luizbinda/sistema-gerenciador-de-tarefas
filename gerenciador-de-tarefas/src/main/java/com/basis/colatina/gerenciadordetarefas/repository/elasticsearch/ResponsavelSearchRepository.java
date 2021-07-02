package com.basis.colatina.gerenciadordetarefas.repository.elasticsearch;

import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.ResponsavelDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResponsavelSearchRepository extends ElasticsearchRepository<ResponsavelDocument, Integer> {

}
