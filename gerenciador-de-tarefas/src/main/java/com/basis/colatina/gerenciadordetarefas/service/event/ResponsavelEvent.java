package com.basis.colatina.gerenciadordetarefas.service.event;

import java.time.LocalDate;

public class ResponsavelEvent extends BaseEvent {

  private LocalDate dataNascimento;

  private String nome;

  private String email;

  private Boolean status;

  public ResponsavelEvent(Integer id) {
    this.id = id;
  }

}
