package com.basis.colatina.gerenciadordetarefas.service.mapper;

import com.basis.colatina.gerenciadordetarefas.domain.Anexo;
import com.basis.colatina.gerenciadordetarefas.service.dto.AnexoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TarefaMapper.class})
public interface AnexoMapper extends EntityMapper<Anexo, AnexoDTO> {
}
