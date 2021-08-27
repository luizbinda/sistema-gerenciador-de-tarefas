package com.basis.colatina.gerenciadordetarefas.service.filter;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.Serializable;

@Getter
@Setter
public class ResponsavelFilter implements BaseFilter, Serializable {

  private String nome;
  private String email;
  private String dataNascimento;

  @Override
  public BoolQueryBuilder getFilter() {
    BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

    addShouldTermQuery(queryBuilder, "nome", nome);
    addShouldTermQuery(queryBuilder, "email", email);
    addShouldTermQuery(queryBuilder, "dataNascimento", dataNascimento);

    return queryBuilder;
  }

}
