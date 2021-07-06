package com.basis.colatina.gerenciadordetarefas.repository.elasticsearch;

import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.AnexoDocument;
import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.ResponsavelDocument;

public interface AnexoSearchRepository extends BasicElasticRepository<AnexoDocument, Integer> {
    @Override
    default Class<AnexoDocument> getEntity() {
        return AnexoDocument.class;
    }
}
