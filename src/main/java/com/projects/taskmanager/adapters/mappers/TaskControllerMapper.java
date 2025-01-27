package com.projects.taskmanager.adapters.mappers;

import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.infraestructure.dtos.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper
public interface TaskControllerMapper {
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

  @Mapping(source = "date", target = "date", qualifiedByName = "localDateToString")
  TaskDto toDto(Task task);

  @Mapping(source = "date", target = "date", qualifiedByName = "stringToLocalDate")
  Task toDomain(TaskDto dto);
}
