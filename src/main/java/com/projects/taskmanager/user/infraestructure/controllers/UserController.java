package com.projects.taskmanager.user.infraestructure.controllers;

import com.projects.taskmanager.core.infraestructure.controllers.CoreController;
import com.projects.taskmanager.user.adapters.controllers.UserControllerAdapter;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.infraestructure.dtos.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends CoreController<User, UserDto, String> {

  public UserController(UserControllerAdapter adapter) {
    super(adapter);
  }
}
