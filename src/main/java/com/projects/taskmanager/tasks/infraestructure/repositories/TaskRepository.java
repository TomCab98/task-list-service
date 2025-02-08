package com.projects.taskmanager.tasks.infraestructure.repositories;

import com.projects.taskmanager.core.infraestructure.repositories.IRepository;
import com.projects.taskmanager.tasks.infraestructure.repositories.entities.TaskEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends IRepository<TaskEntity, String> {}
