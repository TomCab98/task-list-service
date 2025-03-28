package com.projects.taskmanager.task.domain.ports;

import com.projects.taskmanager.core.domain.ports.IControllerPort;
import com.projects.taskmanager.task.infrastructure.dtos.TaskDto;

public interface ITaskControllerPort extends IControllerPort<TaskDto, String> {}
