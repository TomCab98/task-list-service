package com.projects.taskmanager.user.adapters.mappers;

import com.projects.taskmanager.core.adapters.mappers.RepositoryMapper;
import com.projects.taskmanager.user.domain.models.User;
import com.projects.taskmanager.user.infraestructure.repositories.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRepositoryMapper extends RepositoryMapper<User, UserEntity> {}
