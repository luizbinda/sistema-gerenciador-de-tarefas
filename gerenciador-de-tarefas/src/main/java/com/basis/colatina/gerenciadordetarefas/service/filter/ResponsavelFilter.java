package com.basis.colatina.gerenciadordetarefas.service.filter;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.Serializable;

public class ResponsavelFilter implements BaseFilter, Serializable {

  private String query;

  @Override
  public BoolQueryBuilder getFilter() {
    BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

    addShouldTermQuery(queryBuilder, "stringId", query);

    return queryBuilder;
  }

}
