package com.basis.colatina.gerenciadordetarefas.repository.elasticsearch;

import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.ResponsavelDocument;
import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.TarefaDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TarefaSearchRepository extends BasicElasticRepository<TarefaDocument, Integer> {

    @Override
    default Class<TarefaDocument> getEntity() {
        return TarefaDocument.class;
    }
}
