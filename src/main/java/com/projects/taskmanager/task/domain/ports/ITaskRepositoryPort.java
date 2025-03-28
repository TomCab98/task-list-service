package com.projects.taskmanager.task.domain.ports;

import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.task.domain.models.Task;

public interface ITaskRepositoryPort extends IRepositoryPort<Task, String> {}
