package com.basis.colatina.gerenciadordetarefas.service.filter;


import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public interface BaseFilter {

  BoolQueryBuilder getFilter();

  default String getFilterString(String value) {
    return wrapStar(StringUtils.stripAccents(value.toLowerCase().trim()));
  }

  default String wrapStar(String value) {
    return "".concat(value.toLowerCase()).concat("");
  }

  default void addWildcard(BoolQueryBuilder queryBuilder, String field, String value) {
    if (StringUtils.isBlank(value)) {
      return;
    }

    queryBuilder.must(QueryBuilders.wildcardQuery(field, getFilterString(value)));
  }

  default void addRangeQueryLocalDate(BoolQueryBuilder queryBuilder, String field, LocalDate value1, LocalDate value2) {
    if (value1 == null || value2 == null) {
      return;
    }

    queryBuilder.must(QueryBuilders.rangeQuery(field).gte(value1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
            .lte(value2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
  }

  default void addShouldWildCard(BoolQueryBuilder queryBuilder, List<String> fields, String query) {
    if (query == null || CollectionUtils.isEmpty(fields)) {
      return;
    }
    fields.forEach(field -> queryBuilder.should(QueryBuilders.wildcardQuery(field, getFilterString(query))));
  }

  default void addMustNotMatchQuery(BoolQueryBuilder queryBuilder, String field, String value) {
    queryBuilder.mustNot(QueryBuilders.matchQuery(field, value));
  }

  default void addMustTermQuery(BoolQueryBuilder queryBuilder, String field, Object value) {
    if(value == null) {
      return;
    }
    queryBuilder.must(QueryBuilders.termQuery(field, value));
  }

  default void addMustNotTermQuery(BoolQueryBuilder queryBuilder, String field, String value) {
    queryBuilder.mustNot(QueryBuilders.termQuery(field, value));
  }

  default void addMustTermQuery(BoolQueryBuilder queryBuilder, String field, String value) {
    if(value == null) {
      return;
    }
    queryBuilder.must(QueryBuilders.termQuery(field, value));
  }

  default void addShouldTermQuery(BoolQueryBuilder queryBuilder, String field, String value) {
    if(value == null) {
      return;
    }
    queryBuilder.should(QueryBuilders.termQuery(field, value));
  }

  default void filterFields(List<String> fields, String query, BoolQueryBuilder queryBuilder, String ...args) {
    fields.addAll(Arrays.asList(args));
    addShouldWildCard(queryBuilder, fields, query);
  }

}
