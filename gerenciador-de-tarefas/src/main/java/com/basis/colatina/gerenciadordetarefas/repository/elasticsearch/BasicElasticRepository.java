package com.basis.colatina.gerenciadordetarefas.repository.elasticsearch;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasicElasticRepository<T, ID> extends ElasticsearchRepository<T, ID> {

    Class<T> getEntity();

}
