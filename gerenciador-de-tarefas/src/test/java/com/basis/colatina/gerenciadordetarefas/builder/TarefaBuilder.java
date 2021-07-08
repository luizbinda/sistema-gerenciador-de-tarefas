package com.basis.colatina.gerenciadordetarefas.builder;

import com.basis.colatina.gerenciadordetarefas.domain.Tarefa;
import com.basis.colatina.gerenciadordetarefas.repository.TarefaRepository;
import com.basis.colatina.gerenciadordetarefas.service.exception.RegraNegocioException;
import com.basis.colatina.gerenciadordetarefas.service.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class TarefaBuilder extends ConstructorEntity<Tarefa> {

  @Autowired
  private TarefaRepository tarefaRepository;

  @Override
  public Tarefa buildEntity() {
    Tarefa tarefa = new Tarefa();
    tarefa.setTitulo("titulo");
    tarefa.setComentarios("Comentarios");
    tarefa.setStatus("urgente");
    tarefa.setDataInicio(LocalDate.now());
    tarefa.setDataInicioPrevista(LocalDate.now());
    tarefa.setDataTerminoPrevista(LocalDate.now());
    tarefa.setDescricao("descrição");
    tarefa.setTipo("tipo teste");
    return tarefa;
  }

  @Override
  public Tarefa persist(Tarefa entity) {
    return tarefaRepository.save(entity);
  }

  @Override
  public Tarefa findById(Integer id) {
    return tarefaRepository.findById(id).orElseThrow(() -> new RegraNegocioException(ConstantsUtils.RESPONSAVEL_NOT_FOUND));
  }

  @Override
  public Collection<Tarefa> findAll() {
    return tarefaRepository.findAll();
  }
}
