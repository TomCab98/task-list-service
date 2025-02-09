package com.projects.taskmanager.user.adapters.repositories;

import com.projects.taskmanager.core.adapters.repositories.RepositoryAdapter;
import com.projects.taskmanager.user.adapters.mappers.UserRepositoryMapper;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserRepositoryPort;
import com.projects.taskmanager.user.infraestructure.repositories.UserRepository;
import com.projects.taskmanager.user.infraestructure.repositories.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter extends RepositoryAdapter<User, UserEntity, String> implements IUserRepositoryPort {

  public UserRepositoryAdapter(
    UserRepository repository,
    UserRepositoryMapper mapper
  ) {
    super(repository, mapper);
  }
}
