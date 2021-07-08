package com.basis.colatina.gerenciadordetarefas.service.mapper;

import com.basis.colatina.gerenciadordetarefas.domain.elasticsearch.ResponsavelDocument;
import com.basis.colatina.gerenciadordetarefas.service.dto.ResponsavelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelListMapper extends EntityMapper<ResponsavelDocument, ResponsavelDTO> {
}
