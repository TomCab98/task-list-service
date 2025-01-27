package com.projects.taskmanager.infraestructure.repositories;

import com.projects.taskmanager.infraestructure.repositories.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {}
