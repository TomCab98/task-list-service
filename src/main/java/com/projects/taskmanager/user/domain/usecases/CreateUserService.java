package com.projects.taskmanager.user.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.user.adapters.auth.UserDetailsAdapter;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserRepositoryPort;

public class CreateUserService extends CreateService<User, Long> {

  private final UserDetailsAdapter userDetailsAdapter;

  public CreateUserService(IUserRepositoryPort repository, UserDetailsAdapter userDetailsAdapter) {
    super(repository);
    this.userDetailsAdapter = userDetailsAdapter;
  }

  @Override
  public User create(User model) {
    model.setPassword(userDetailsAdapter.encodePassword(model.getPassword()));
    return super.create(model);
  }
}
