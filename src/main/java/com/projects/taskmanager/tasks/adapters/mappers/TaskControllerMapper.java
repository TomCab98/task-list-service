package com.projects.taskmanager.tasks.adapters.mappers;

import com.projects.taskmanager.core.adapters.mappers.ControllerMapper;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.infrastructure.dtos.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskControllerMapper extends ControllerMapper<Task, TaskDto> {
  TaskControllerMapper INSTANCE = Mappers.getMapper(TaskControllerMapper.class);

  @Named("stringToLocalDate")
  static LocalDate stringToLocalDate(String date) {
    if (date == null) {
      return null;
    }
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      return LocalDate.parse(date, formatter);
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid date format: " + date, e);
    }
  }

  @Named("localDateToString")
  static String localDateToString(LocalDate date) {
    return date != null ? date.toString() : null;
  }

  @Override
  @Mapping(source = "date", target = "date", qualifiedByName = "localDateToString")
  TaskDto toDto(Task task);

  @Override
  @Mapping(source = "date", target = "date", qualifiedByName = "stringToLocalDate")
  Task toDomain(TaskDto dto);

  @Override
  default List<TaskDto> toDtoList(List<Task> tasks) {
    return tasks.stream().map(this::toDto).toList();
  }
}
