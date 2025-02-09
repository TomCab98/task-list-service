package com.projects.taskmanager.user.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserRepositoryPort;

public class CreateUserService extends CreateService<User, String> {

  public CreateUserService(IUserRepositoryPort repository) {
    super(repository);
  }
}
