package com.projects.taskmanager.adapters.mappers;

import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.infraestructure.repositories.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskRepositoryMapper {
  TaskRepositoryMapper INSTANCE = Mappers.getMapper(TaskRepositoryMapper.class);

  TaskEntity toEntity(Task task);

  Task toDomain(TaskEntity dto);
}
