package com.projects.taskmanager.user.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "message", "jwt", "status"})
public record AuthResponseDto(
  String email,
  String message,
  String jwt,
  boolean status
) {}
