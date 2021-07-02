package com.basis.colatina.gerenciadordetarefas.service;

import com.basis.colatina.gerenciadordetarefas.domain.Tarefa;
import com.basis.colatina.gerenciadordetarefas.feing.AnexoClient;
import com.basis.colatina.gerenciadordetarefas.repository.TarefaRepository;
import com.basis.colatina.gerenciadordetarefas.service.dto.TarefaDTO;
import com.basis.colatina.gerenciadordetarefas.service.exception.RegraNegocioException;
import com.basis.colatina.gerenciadordetarefas.service.mapper.TarefaMapper;
import com.basis.colatina.gerenciadordetarefas.service.utils.ConstantsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TarefaService {

  private final TarefaRepository tarefaRepository;
  private final TarefaMapper tarefaMapper;

  public List<TarefaDTO> index() {
    return tarefaMapper.toDTO(tarefaRepository.findAll());
  }

  public TarefaDTO show(Integer id) {
    Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException(ConstantsUtils.USER_NOT_FOUND)
    );
    return tarefaMapper.toDTO(tarefa);
  }

  public TarefaDTO save(TarefaDTO reponsavelDTO) {
    Tarefa tarefa = tarefaMapper.toEntity(reponsavelDTO);
    return tarefaMapper.toDTO(tarefaRepository.save(tarefa));
  }

  public void delete(Integer id) {
    Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException(ConstantsUtils.USER_NOT_FOUND)
    );
    tarefaRepository.delete(tarefa);
  }

}
