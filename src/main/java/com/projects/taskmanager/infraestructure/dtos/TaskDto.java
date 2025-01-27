package com.projects.taskmanager.infraestructure.dtos;

import lombok.Data;

@Data
public class TaskDto {
  private String id;
  private String name;
  private String date;
  private boolean reminder;
}