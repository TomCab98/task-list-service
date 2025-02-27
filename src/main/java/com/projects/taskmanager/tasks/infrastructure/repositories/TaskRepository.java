package com.projects.taskmanager.tasks.infrastructure.repositories;

import com.projects.taskmanager.core.infrastructure.repositories.IRepository;
import com.projects.taskmanager.tasks.infrastructure.repositories.entities.TaskEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends IRepository<TaskEntity, String> {}
