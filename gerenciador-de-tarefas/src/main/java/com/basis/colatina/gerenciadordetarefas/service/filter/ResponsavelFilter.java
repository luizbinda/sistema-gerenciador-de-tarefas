package com.basis.colatina.gerenciadordetarefas.service.filter;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.Serializable;

@Getter
@Setter
public class ResponsavelFilter implements BaseFilter, Serializable {

  private String query;

  @Override
  public BoolQueryBuilder getFilter() {
    BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

    addShouldTermQuery(queryBuilder, "nome", query);
    addShouldTermQuery(queryBuilder, "email", query);

    return queryBuilder;
  }

}
