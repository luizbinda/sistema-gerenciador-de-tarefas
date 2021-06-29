package com.basis.colatina.gerenciadordetarefas.service.mapper;

import com.basis.colatina.gerenciadordetarefas.domain.Responsavel;
import com.basis.colatina.gerenciadordetarefas.service.dto.ResponsavelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper extends EntityMapper<Responsavel, ResponsavelDTO> {
}
