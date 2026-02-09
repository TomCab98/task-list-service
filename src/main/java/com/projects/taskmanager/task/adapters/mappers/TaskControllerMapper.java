package com.projects.taskmanager.task.adapters.mappers;

import com.projects.taskmanager.core.adapters.mappers.ControllerMapper;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.infrastructure.dtos.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskControllerMapper extends ControllerMapper<Task, TaskDto> {
  @Override
  default List<TaskDto> toDtoList(List<Task> tasks) {
    return tasks.stream().map(this::toDto).toList();
  }
}
