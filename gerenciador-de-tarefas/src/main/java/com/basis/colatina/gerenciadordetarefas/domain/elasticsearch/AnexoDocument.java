package com.basis.colatina.gerenciadordetarefas.domain.elasticsearch;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

@Document(indexName = "gerenciador-de-tarefas-responsavel")
public class AnexoDocument extends BaseDocument {

  private static final String SORT = "sort";

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String hash;

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String tipo;

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String titulo;

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String tamanho;

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String tarefa;

  public AnexoDocument(Integer id, String hash, String tipo, String titulo, String tamanho, String tarefa) {
    super(id);
    this.hash = hash;
    this.tipo = tipo;
    this.titulo = titulo;
    this.tamanho = tamanho;
    this.tarefa = tarefa;
  }
}
