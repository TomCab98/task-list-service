package com.projects.taskmanager.adapters.mappers;

import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.infraestructure.repositories.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TaskRepositoryMapper {
  TaskRepositoryMapper INSTANCE = Mappers.getMapper(TaskRepositoryMapper.class);

  default Optional<TaskEntity> toEntity(Optional<Task> task) {
    return task.map(this::toEntity);
  }

  default Optional<Task> toDomain(Optional<TaskEntity> taskDto) {
    return taskDto.map(this::toDomain);
  }

  TaskEntity toEntity(Task task);

  Task toDomain(TaskEntity dto);

  default List<Task> toDomainList(List<TaskEntity> tasks) {
    return tasks.stream().map(this::toDomain).toList();
  }
}
