package com.projects.taskmanager.user.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.DeleteService;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserRepositoryPort;

public class DeleteUserService extends DeleteService<User, String> {

  public DeleteUserService(IUserRepositoryPort repository, FindUserService findService) {
    super(repository, findService);
  }
}
