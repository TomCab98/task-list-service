package com.projects.taskmanager.user.adapters.auth;

import com.projects.taskmanager.user.adapters.mappers.UserControllerMapper;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.usecases.CreateUserService;
import com.projects.taskmanager.user.infrastructure.dtos.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserAuthAdapter {

  private final CreateUserService createUserService;
  private final UserControllerMapper userMapper;

  public UserDto createUser(UserDto userDto) {
    User user = userMapper.toDomain(userDto);
    User created = createUserService.create(user);
    return userMapper.toDto(created);
  }
}
