package com.basis.colatina.gerenciadordetarefas.service.mapper;

import com.basis.colatina.gerenciadordetarefas.domain.Anexo;
import com.basis.colatina.gerenciadordetarefas.service.dto.AnexoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TarefaMapper.class})
public interface AnexoMapper extends EntityMapper<Anexo, AnexoDTO> {

    @Override
    @Mapping(target = "tarefa.id", source = "tarefaId")
    Anexo toEntity(AnexoDTO anexoDTO);
}
