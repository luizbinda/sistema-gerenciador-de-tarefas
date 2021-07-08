package com.basis.colatina.gerenciadordetarefas.builder;

import com.basis.colatina.gerenciadordetarefas.domain.Anexo;
import com.basis.colatina.gerenciadordetarefas.domain.Tarefa;
import com.basis.colatina.gerenciadordetarefas.repository.AnexoRepository;
import com.basis.colatina.gerenciadordetarefas.service.exception.RegraNegocioException;
import com.basis.colatina.gerenciadordetarefas.service.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
public class AnexoBuilder extends ConstructorEntity<Anexo> {

  @Autowired
  private AnexoRepository anexoRepository;

  @Autowired
  private TarefaBuilder tarefaBuilder;

  @Override
  public Anexo buildEntity() {
    Anexo anexo = new Anexo();
    anexo.setTitulo("titulo");
    anexo.setTipo("tipo teste");
    anexo.setHash(UUID.randomUUID().toString());
    anexo.setTamanho("tipo teste");
    Tarefa tarefa = tarefaBuilder.persist(tarefaBuilder.buildEntity());
    anexo.setTarefa(tarefa);
    return anexo;
  }

  @Override
  public Anexo persist(Anexo entity) {
    return anexoRepository.save(entity);
  }

  @Override
  public Anexo findById(Integer id) {
    return anexoRepository.findById(id).orElseThrow(() -> new RegraNegocioException(ConstantsUtils.RESPONSAVEL_NOT_FOUND));
  }

  @Override
  public Collection<Anexo> findAll() {
    return anexoRepository.findAll();
  }
}
