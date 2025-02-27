package com.projects.taskmanager.user.infrastructure.repositories;

import com.projects.taskmanager.core.infrastructure.repositories.IRepository;
import com.projects.taskmanager.user.infrastructure.repositories.entities.RoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends IRepository<RoleEntity, String> {

  Set<RoleEntity> findByRoleIn(List<String> roles);
}
