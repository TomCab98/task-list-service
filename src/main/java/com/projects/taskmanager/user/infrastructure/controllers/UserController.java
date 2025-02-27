package com.projects.taskmanager.user.infrastructure.controllers;

import com.projects.taskmanager.core.infrastructure.controllers.CoreController;
import com.projects.taskmanager.user.adapters.controllers.UserControllerAdapter;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.infrastructure.dtos.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends CoreController<User, UserDto, String> {

  public UserController(UserControllerAdapter adapter) {
    super(adapter);
  }
}
