package com.basis.colatina.gerenciadordetarefas.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class AnexoDTO implements Serializable {

  private Integer id;

  private String hash;

  private String tipo;

  private String titulo;

  private String tamanho;

  private Integer tarefaId;

}
