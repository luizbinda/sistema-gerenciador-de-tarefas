package com.basis.colatina.gerenciadordetarefas.service.dto;

import com.basis.colatina.gerenciadordetarefas.service.utils.ConstantsUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ResponsavelDTO implements Serializable {

  private Integer id;

  @NotNull(message = ConstantsUtils.RESPONSAVEL_DATE_NASCIMENTO_NOT_NULL)
  private LocalDate dataNascimento;

  @NotNull(message = ConstantsUtils.RESPONSAVEL_NAME_NOT_NULL)
  private String nome;

  @Email(message = ConstantsUtils.RESPONSAVEL_EMAIL_FORMAT_INVALID)
  @NotNull(message = ConstantsUtils.RESPONSAVEL_EMAIL_NOT_NULL)
  private String email;

  private Boolean status = true;

}
