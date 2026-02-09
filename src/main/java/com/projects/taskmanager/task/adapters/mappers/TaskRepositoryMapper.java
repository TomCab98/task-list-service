package com.projects.taskmanager.task.adapters.mappers;

import com.projects.taskmanager.core.adapters.mappers.RepositoryMapper;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.infrastructure.repositories.entities.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TaskRepositoryMapper extends RepositoryMapper<Task, TaskEntity> {
  @Override
  default Optional<Task> toDomain(Optional<TaskEntity> taskDto) {
    return taskDto.map(this::toDomain);
  }

  @Override
  default List<Task> toDomainList(List<TaskEntity> tasks) {
    return tasks.stream().map(this::toDomain).toList();
  }
}
