package com.projects.taskmanager.task.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String description;

  private LocalDate creationDate;

  private LocalDate reminderDate;

  private boolean reminder;

  @Column(name = "user_email", updatable = false, nullable = false)
  private String userEmail;
}
