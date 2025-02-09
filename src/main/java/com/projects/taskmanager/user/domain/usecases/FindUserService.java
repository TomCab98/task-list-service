package com.projects.taskmanager.user.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.FindService;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserRepositoryPort;

public class FindUserService extends FindService<User, String> {

  public FindUserService(IUserRepositoryPort repository) {
    super(repository);
  }
}
