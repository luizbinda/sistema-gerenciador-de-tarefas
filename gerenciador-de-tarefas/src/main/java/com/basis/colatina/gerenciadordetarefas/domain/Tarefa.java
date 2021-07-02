package com.basis.colatina.gerenciadordetarefas.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tarefa", schema = "public")
public class Tarefa implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_tarefa")
  @SequenceGenerator(name = "seq_tarefa", allocationSize = 1, sequenceName = "seq_tarefa")
  @Column(name = "id")
  private Integer id;

  @Column(name = "data_inicio")
  private LocalDate dataInicio;

  @Column(name = "data_inicio_prevista")
  private LocalDate dataInicioPrevista;

  @Column(name = "data_termino_prevista")
  private LocalDate dataTerminoPrevista;

  @Column(name = "status")
  private String status;

  @Column(name = "comentarios")
  private String comentarios;

  @Column(name = "tipo")
  private String tipo;

  @Column(name = "titulo")
  private String titulo;

  @Column(name = "descricao")
  private String descricao;

}
