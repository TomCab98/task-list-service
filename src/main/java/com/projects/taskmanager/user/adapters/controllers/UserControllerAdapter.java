package com.projects.taskmanager.user.adapters.controllers;

import com.projects.taskmanager.core.adapters.controllers.ControllerAdapter;
import com.projects.taskmanager.user.adapters.mappers.UserControllerMapper;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserControllerPort;
import com.projects.taskmanager.user.domain.usecases.CreateUserService;
import com.projects.taskmanager.user.domain.usecases.DeleteUserService;
import com.projects.taskmanager.user.domain.usecases.FindUserService;
import com.projects.taskmanager.user.domain.usecases.UpdateUserService;
import com.projects.taskmanager.user.infrastructure.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserControllerAdapter extends ControllerAdapter<User, UserDto, String> implements IUserControllerPort {

  public UserControllerAdapter(
    CreateUserService createService,
    UpdateUserService updateService,
    FindUserService findService,
    DeleteUserService deleteService,
    UserControllerMapper mapper
  ) {
    super(createService, updateService, findService, deleteService, mapper);
  }
}
