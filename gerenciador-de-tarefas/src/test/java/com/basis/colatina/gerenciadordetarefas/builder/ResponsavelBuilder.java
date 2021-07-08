package com.basis.colatina.gerenciadordetarefas.builder;

import com.basis.colatina.gerenciadordetarefas.domain.Responsavel;
import com.basis.colatina.gerenciadordetarefas.repository.ResponsavelRepository;
import com.basis.colatina.gerenciadordetarefas.service.exception.RegraNegocioException;
import com.basis.colatina.gerenciadordetarefas.service.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class ResponsavelBuilder extends ConstructorEntity<Responsavel> {

  @Autowired
  private ResponsavelRepository responsavelRepository;



  @Override
  public Responsavel buildEntity() {
    Responsavel responsavel = new Responsavel();
    responsavel.setNome("Responsavel");
    responsavel.setEmail("responsavel@gmail.com");
    responsavel.setDataNascimento(LocalDate.now());
    responsavel.setStatus(true);
    return responsavel;
  }

  @Override
  public Responsavel persist(Responsavel entity) {
    return responsavelRepository.save(entity);
  }

  @Override
  public Responsavel findById(Integer id) {
    return responsavelRepository.findById(id).orElseThrow(() -> new RegraNegocioException(ConstantsUtils.RESPONSAVEL_NOT_FOUND));
  }

  @Override
  public Collection<Responsavel> findAll() {
    return responsavelRepository.findAll();
  }
}
