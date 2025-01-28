package com.projects.taskmanager.infraestructure.configuration.beans;

import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.usecases.CreateTaskService;
import com.projects.taskmanager.domain.usecases.DeleteTaskService;
import com.projects.taskmanager.domain.usecases.FindTaskService;
import com.projects.taskmanager.domain.usecases.UpdateTaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskBeanConfig {

  @Bean
  public CreateTaskService createTaskService(TaskRepositoryAdapter repository) {
    return new CreateTaskService(repository);
  }

  @Bean
  public UpdateTaskService updateTaskService(TaskRepositoryAdapter repository) {
    return new UpdateTaskService(repository);
  }

  @Bean
  public DeleteTaskService deleteTaskService(TaskRepositoryAdapter repository) {
    return new DeleteTaskService(repository);
  }

  @Bean
  public FindTaskService findTaskService(TaskRepositoryAdapter repository) {
    return new FindTaskService(repository);
  }
}
