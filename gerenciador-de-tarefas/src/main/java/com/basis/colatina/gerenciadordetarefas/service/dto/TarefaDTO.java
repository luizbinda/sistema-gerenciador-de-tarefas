package com.basis.colatina.gerenciadordetarefas.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TarefaDTO implements Serializable {

  private Integer id;

  private LocalDate dataInicio;

  private LocalDate dataInicioPrevista;

  private LocalDate dataTerminoPrevista;

  private String status;

  private String comentarios;

  private String tipo;

  private String titulo;

  private String descricao;

  private Integer responsavelId;

}
