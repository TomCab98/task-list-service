package com.projects.taskmanager.user.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.user.adapters.auth.UserAuthAdapter;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserRepositoryPort;

public class CreateUserService extends CreateService<User, String> {

  private final UserAuthAdapter auth;

  public CreateUserService(IUserRepositoryPort repository, UserAuthAdapter auth) {
    super(repository);
    this.auth = auth;
  }

  @Override
  public User create(User model) {
    model.setPassword(auth.encodePassword(model.getPassword()));
    return super.create(model);
  }
}
