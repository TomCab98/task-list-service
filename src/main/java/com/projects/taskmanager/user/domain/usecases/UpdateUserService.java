package com.projects.taskmanager.user.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.UpdateService;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserRepositoryPort;

public class UpdateUserService extends UpdateService<User, String> {

  public UpdateUserService(IUserRepositoryPort repository) {
    super(repository);
  }
}
