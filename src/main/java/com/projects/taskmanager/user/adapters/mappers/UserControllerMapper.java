package com.projects.taskmanager.user.adapters.mappers;

import com.projects.taskmanager.core.adapters.mappers.ControllerMapper;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.infrastructure.dtos.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserControllerMapper extends ControllerMapper<User, UserDto> {}
