package com.basis.colatina.gerenciadordetarefas.service.event;

public class AnexoEvent extends BaseEvent {

  private String hash;

  private String anexo;

  private String tipo;

  private String titulo;

  private String tamanho;

  private Integer tarefaId;

  public AnexoEvent(Integer id) {
    this.id = id;
  }

}
