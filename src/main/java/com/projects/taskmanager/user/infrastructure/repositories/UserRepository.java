package com.projects.taskmanager.user.infrastructure.repositories;

import com.projects.taskmanager.core.infrastructure.repositories.IRepository;
import com.projects.taskmanager.user.infrastructure.repositories.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends IRepository<UserEntity, String> {

  Optional<UserEntity> findUserEntityByUsername(String username);
}
