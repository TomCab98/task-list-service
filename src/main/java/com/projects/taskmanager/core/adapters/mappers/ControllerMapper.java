package com.projects.taskmanager.core.adapters.mappers;

import java.util.List;

public interface ControllerMapper<M, DTO> {
  DTO toDto(M model);

  M toDomain(DTO dto);

  List<DTO> toDtoList(List<M> models);
}
