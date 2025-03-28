package com.projects.taskmanager.task.infrastructure.repositories;

import com.projects.taskmanager.core.infrastructure.repositories.IRepository;
import com.projects.taskmanager.task.infrastructure.repositories.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends IRepository<TaskEntity, String> {
  List<TaskEntity> findByUserEmail(String userEmail);
  Optional<TaskEntity> findByIdAndUserEmail(String id, String userEmail);
  void deleteByUserEmail(String userEmail);
}
