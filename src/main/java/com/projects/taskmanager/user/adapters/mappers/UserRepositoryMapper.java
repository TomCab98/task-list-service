package com.projects.taskmanager.user.adapters.mappers;

import com.projects.taskmanager.core.adapters.mappers.RepositoryMapper;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.infrastructure.annotation.ToUserEntity;
import com.projects.taskmanager.user.infrastructure.repositories.entities.RoleEntity;
import com.projects.taskmanager.user.infrastructure.repositories.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserRepositoryMapper extends RepositoryMapper<User, UserEntity> {

  @Named("toRoleList")
  static List<String> toRoleList(Set<RoleEntity> roles) {
    return roles.stream()
      .map(roleEntity -> roleEntity.getRole().name())
      .toList();
  }

  @Override
  @Mapping(target = "roles", source = "roles", qualifiedByName = "toRoleList")
  User toDomain(UserEntity entity);

  @Override
  @Mapping(target = "roles", ignore = true)
  @ToUserEntity
  UserEntity toEntity(User user);

  @Mapping(target = "roles", source = "roles")
  @ToUserEntity
  UserEntity toEntity(User user, Set<RoleEntity> roles);
}
