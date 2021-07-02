package com.basis.colatina.gerenciadordeanexos.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnexoDTO implements Serializable {

  private String hash;

  private String anexo;

}
