package com.basis.colatina.gerenciadordetarefas.service.filter;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponsavelFilter implements BaseFilter, Serializable {

  protected String query;

  @Override
  public BoolQueryBuilder getFilter() {
    BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
    List<String> fields = new ArrayList<>();
    filterFields(fields, query, queryBuilder, "nome", "email");

    return queryBuilder;
  }

}
