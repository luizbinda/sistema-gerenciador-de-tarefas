package com.basis.colatina.gerenciadordetarefas.domain.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;
import java.io.Serializable;

@Setting(settingPath = "/config/elasticsearch/elastic.json")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDocument implements Serializable {

  private static final String SORT = "sort";

  @MultiField(mainField = @Field(type = FieldType.Integer, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Integer, store = true)}
  )
  private Integer id;

}
