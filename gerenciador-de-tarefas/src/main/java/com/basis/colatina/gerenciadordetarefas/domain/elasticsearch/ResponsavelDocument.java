package com.basis.colatina.gerenciadordetarefas.domain.elasticsearch;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.time.LocalDate;

@Document(indexName = "gerenciador-de-tarefas-responsavel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsavelDocument extends BaseDocument {

  private static final String SORT = "sort";

  @Field(type = FieldType.Date, store = true, format = DateFormat.year_month_day, pattern = "yyyy-MM-dd")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
  private LocalDate dataNascimento;

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String nome;

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String email;

  @MultiField(mainField = @Field(type = FieldType.Boolean, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private Boolean status;

  public ResponsavelDocument(Integer id, LocalDate dataNascimento, String nome, String email, Boolean status) {
    super(id);
    this.dataNascimento = dataNascimento;
    this.nome = nome;
    this.email = email;
    this.status = status;
  }

}
