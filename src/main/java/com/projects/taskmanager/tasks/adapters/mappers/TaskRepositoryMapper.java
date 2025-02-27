package com.projects.taskmanager.tasks.adapters.mappers;

import com.projects.taskmanager.core.adapters.mappers.RepositoryMapper;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.infrastructure.repositories.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TaskRepositoryMapper extends RepositoryMapper<Task, TaskEntity> {
  TaskRepositoryMapper INSTANCE = Mappers.getMapper(TaskRepositoryMapper.class);

  @Override
  default Optional<Task> toDomain(Optional<TaskEntity> taskDto) {
    return taskDto.map(this::toDomain);
  }

  @Override
  TaskEntity toEntity(Task task);

  @Override
  Task toDomain(TaskEntity dto);

  @Override
  default List<Task> toDomainList(List<TaskEntity> tasks) {
    return tasks.stream().map(this::toDomain).toList();
  }
}
