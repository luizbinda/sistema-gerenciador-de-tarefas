package com.basis.colatina.gerenciadordetarefas.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "anexo", schema = "public")
public class Anexo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_anexo")
  @SequenceGenerator(name = "seq_user", allocationSize = 1, sequenceName = "seq_user")
  @Column(name = "id")
  private Integer id;

  @Column(name = "hash")
  private String hash;

  @Column(name = "tipo")
  private String tipo;

  @Column(name = "titulo")
  private String titulo;

  @Column(name = "tamanho")
  private String tamanho;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tarefa_id")
  private Tarefa tarefa;

}
