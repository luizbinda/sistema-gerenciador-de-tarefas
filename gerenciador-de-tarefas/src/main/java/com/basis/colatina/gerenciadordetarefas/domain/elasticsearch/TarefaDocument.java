package com.basis.colatina.gerenciadordetarefas.domain.elasticsearch;

import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDate;

@Document(indexName = "gerenciador-de-tarefas-tarefa")
public class TarefaDocument extends BaseDocument {

  private static final String SORT = "sort";

  @MultiField(mainField = @Field(type = FieldType.Date, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Date, store = true)}
  )
  private LocalDate dataInicio;

  @MultiField(mainField = @Field(type = FieldType.Date, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Date, store = true)}
  )
  private LocalDate dataInicioPrevista;

  @MultiField(mainField = @Field(type = FieldType.Date, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Date, store = true)}
  )
  private LocalDate dataTerminoPrevista;

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String status;

  @MultiField(mainField = @Field(type = FieldType.Text, store = true),
          otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)}
  )
  private String comentarios;

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
  private String descricao;

  private String responsavel;

  public TarefaDocument(Integer id, LocalDate dataInicio, LocalDate dataInicioPrevista, LocalDate dataTerminoPrevista, String status, String comentarios, String tipo, String titulo, String descricao, String responsavel) {
    super(id);
    this.dataInicio = dataInicio;
    this.dataInicioPrevista = dataInicioPrevista;
    this.dataTerminoPrevista = dataTerminoPrevista;
    this.status = status;
    this.comentarios = comentarios;
    this.tipo = tipo;
    this.titulo = titulo;
    this.descricao = descricao;
    this.responsavel = responsavel;
  }
}
