package com.projects.taskmanager.task.infrastructure.repositories;

import com.projects.taskmanager.core.infrastructure.repositories.IRepository;
import com.projects.taskmanager.task.infrastructure.repositories.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends IRepository<TaskEntity, Long> {

  List<TaskEntity> findByUserEmail(String userEmail);

  Optional<TaskEntity> findByIdAndUserEmail(Long id, String userEmail);

  void deleteByIdAndUserEmail(Long id, String userEmail);
}
