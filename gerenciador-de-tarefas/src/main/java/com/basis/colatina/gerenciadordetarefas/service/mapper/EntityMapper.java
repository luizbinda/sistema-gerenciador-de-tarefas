package com.basis.colatina.gerenciadordetarefas.service.mapper;

import java.util.List;

public interface EntityMapper<Entity, DTO> {

  Entity toEntity(DTO dto);

  DTO toDTO(Entity entity);

  Iterable<DTO> iterableToDTO(Iterable<Entity> entities);

  List<DTO> ToDTO(List<Entity> entities);

  List<Entity> ToEntity(List<DTO> dtos);
}
