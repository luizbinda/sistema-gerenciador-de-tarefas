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
@Table(name = "responsavel", schema = "public")
public class Responsavel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_responsavel")
  @SequenceGenerator(name = "seq_user", allocationSize = 1, sequenceName = "seq_user")
  @Column(name = "id")
  private Integer id;

  @Column(name = "dt_nascimento")
  private LocalDate dataNascimento;

  @Column(name = "nome")
  private String nome;

  @Column(name = "email")
  private String email;

  @Column(name = "status")
  private Boolean status;

}
