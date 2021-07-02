package com.basis.colatina.gerenciadordetarefas.service.mapper;

import com.basis.colatina.gerenciadordetarefas.domain.Tarefa;
import com.basis.colatina.gerenciadordetarefas.service.dto.TarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper extends EntityMapper<Tarefa, TarefaDTO> {
}
