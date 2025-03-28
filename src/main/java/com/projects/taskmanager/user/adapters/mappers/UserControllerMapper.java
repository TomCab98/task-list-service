package com.projects.taskmanager.user.adapters.mappers;

import com.projects.taskmanager.core.adapters.mappers.ControllerMapper;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.infrastructure.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserControllerMapper extends ControllerMapper<User, UserDto> {
  @Named("setRoles")
  static List<String> setRoles(List<String> roles) {
    return (roles != null) ? roles : Collections.singletonList("USER");
  }

  @Override
  @Mapping(target = "roles", source = "roles", qualifiedByName = "setRoles", defaultExpression = "java(java.util.Collections.singletonList(\"USER\"))")
  User toDomain(UserDto userDto);
}
