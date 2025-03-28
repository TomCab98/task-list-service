package com.projects.taskmanager.task.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  private LocalDate date;

  private boolean reminder;

  @Column(name = "user_email", updatable = false, nullable = false)
  private String userEmail;
}
