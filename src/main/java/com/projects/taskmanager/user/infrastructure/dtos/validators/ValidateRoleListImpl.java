package com.projects.taskmanager.user.infrastructure.dtos.validators;

import com.projects.taskmanager.user.infrastructure.dtos.RoleEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateRoleListImpl implements ConstraintValidator<ValidateRoleList, List<String>> {

  private List<String> validRoles;

  @Override
  public void initialize(ValidateRoleList constraintAnnotation) {
    validRoles = Arrays.stream(RoleEnum.values())
      .map(Enum::name)
      .collect(Collectors.toList());
  }

  @Override
  public boolean isValid(List<String> roles, ConstraintValidatorContext context) {
    if (roles == null || roles.isEmpty()) {
      return false;
    }
    return new HashSet<>(validRoles).containsAll(roles);
  }
}
