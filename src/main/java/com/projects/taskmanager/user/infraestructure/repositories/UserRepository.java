package com.projects.taskmanager.user.infraestructure.repositories;

import com.projects.taskmanager.core.infraestructure.repositories.IRepository;
import com.projects.taskmanager.user.infraestructure.repositories.entities.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends IRepository<UserEntity, String> {}
