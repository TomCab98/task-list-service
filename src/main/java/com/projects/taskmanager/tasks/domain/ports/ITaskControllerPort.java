package com.projects.taskmanager.tasks.domain.ports;

import com.projects.taskmanager.core.domain.ports.IControllerPort;
import com.projects.taskmanager.tasks.infrastructure.dtos.TaskDto;

public interface ITaskControllerPort extends IControllerPort<TaskDto, String> {}
