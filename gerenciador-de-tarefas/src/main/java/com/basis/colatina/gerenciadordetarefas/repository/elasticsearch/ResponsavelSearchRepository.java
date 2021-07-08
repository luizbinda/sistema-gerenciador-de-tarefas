package com.basis.colatina.gerenciadordetarefas.repository.elasticsearch;

import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.ResponsavelDocument;

public interface ResponsavelSearchRepository extends BasicElasticRepository<ResponsavelDocument, Integer> {
    @Override
    default Class<ResponsavelDocument> getEntity() {
        return ResponsavelDocument.class;
    }

}
