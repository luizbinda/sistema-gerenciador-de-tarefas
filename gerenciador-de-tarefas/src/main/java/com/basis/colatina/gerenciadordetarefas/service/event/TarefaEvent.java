package com.basis.colatina.gerenciadordetarefas.service.event;

import java.time.LocalDate;

public class TarefaEvent extends BaseEvent {

  private LocalDate dataInicio;

  private LocalDate dataInicioPrevista;

  private LocalDate dataTerminoPrevista;

  private String status;

  private String comentarios;

  private String tipo;

  private String titulo;

  private String descricao;

  public TarefaEvent(Integer id) {
    this.id = id;
  }

}
