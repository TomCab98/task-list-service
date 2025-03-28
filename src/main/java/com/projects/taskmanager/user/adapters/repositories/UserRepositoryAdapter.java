package com.projects.taskmanager.user.adapters.repositories;

import com.projects.taskmanager.core.adapters.repositories.RepositoryAdapter;
import com.projects.taskmanager.core.domain.exceptions.NotFoundException;
import com.projects.taskmanager.user.adapters.mappers.UserRepositoryMapper;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.domain.ports.IUserRepositoryPort;
import com.projects.taskmanager.user.infrastructure.repositories.RoleRepository;
import com.projects.taskmanager.user.infrastructure.repositories.UserRepository;
import com.projects.taskmanager.user.infrastructure.repositories.entities.RoleEntity;
import com.projects.taskmanager.user.infrastructure.repositories.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserRepositoryAdapter extends RepositoryAdapter<User, UserEntity, String> implements IUserRepositoryPort {

  private final RoleRepository roleRepository;
  private final UserRepositoryMapper mapper;
  private final UserRepository userRepository;

  public UserRepositoryAdapter(
    UserRepository repository,
    UserRepositoryMapper mapper,
    RoleRepository roleRepository
  ) {
    super(repository, mapper);
    this.userRepository =  repository;
    this.roleRepository = roleRepository;
    this.mapper = mapper;
  }

  @Override
  public User create(User domain) {
    Set<RoleEntity> roles = roleRepository.findByRoleIn(domain.getRoles());
    if (roles.isEmpty()) {
      throw new NotFoundException("not found roles in database: " + roles);
    }

    UserEntity entity = mapper.toEntity(domain, roles);
    UserEntity created = userRepository.save(entity);
    return mapper.toDomain(created);
  }
}
