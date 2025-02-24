package com.projects.taskmanager.user.infrastructure.configuration.beans;

import com.projects.taskmanager.user.adapters.repositories.UserRepositoryAdapter;
import com.projects.taskmanager.user.domain.usecases.CreateUserService;
import com.projects.taskmanager.user.domain.usecases.DeleteUserService;
import com.projects.taskmanager.user.domain.usecases.FindUserService;
import com.projects.taskmanager.user.domain.usecases.UpdateUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfig {

  @Bean
  public CreateUserService createUserService(UserRepositoryAdapter repository) {
    return new CreateUserService(repository);
  }

  @Bean
  public UpdateUserService updateUserService(UserRepositoryAdapter repository) {
    return new UpdateUserService(repository);
  }

  @Bean
  public DeleteUserService deleteUserService(UserRepositoryAdapter repository, FindUserService findUserService) {
    return new DeleteUserService(repository, findUserService);
  }

  @Bean
  public FindUserService findUserService(UserRepositoryAdapter repository) {
    return new FindUserService(repository);
  }
}
